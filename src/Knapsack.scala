import scala.collection.immutable.TreeSet
import scala.collection.{SetLike, SortedSet}

/**
 * Knapsack algorithm modified to track multiple probabilities for each weight.
 */

/**
 * Items to use in the knapsack algorithm
 *
 * @param name descriptive name
 * @param weight
 * @param value probability of this item
 */
case class KnapsackItem(name: String, weight: Int, value: Double = 0.0) {

  override def toString(): String = {
    name
  }
}

case class ItemGroup(values: Set[KnapsackItem]) {

  import Knapsack.sumWeight

  val weight = sumWeight(values)
  val probability = values.foldLeft(1.0){_ * _.value} //

  override def toString(): String = {
    values.toSeq.sortBy(_.name).mkString("(",", ","): " + probability)
  }

  def +(elem: KnapsackItem): Set[KnapsackItem] = {
    values + elem
  }
}

object ItemSetOrdering extends Ordering[ItemGroup] {

  // Note: reversed to ensure that high numbers come first
  override def compare(a: ItemGroup, b: ItemGroup): Int = {
    if (a.probability < b.probability)
      1
    else if (a.probability == b.probability)
      0
    else
      -1
  }

}

/**
 * Immutable
 *
 * Represents all possible KnapsackItem combinations for a particular Knapsack matrix cell up to our limit
 */
object KnapsackData {

  val MaxValues = 20 // Only keep track of this many values (otherwise we could easily use up too much memory)

  def apply(): KnapsackData = {
    new KnapsackData(new TreeSet[ItemGroup]()(ItemSetOrdering))
  }

  def limit(values: TreeSet[ItemGroup]): TreeSet[ItemGroup] = {
    values.take(MaxValues)
  }
}

class KnapsackData (val values: TreeSet[ItemGroup]) {

  import KnapsackData.limit

  def add(data: KnapsackData): KnapsackData = {
    new KnapsackData(limit(values ++ data.values))
  }

  def add(item: KnapsackItem): KnapsackData = {
    new KnapsackData(values + ItemGroup(Set(item)))
  }

  /**
   * Return a new KnapsackData that has the given item inserted into all groups
   *
   * For example if we have
   * groups (a,b) and (d,e) and we insert item c we will return
   * (a,b,c) and (d,e,c)
   *
   * NOTE: If we have hit our size limit we return only the highest value groups.
   */
  def insert(newItem: KnapsackItem): KnapsackData = {
    val newValues = values.map { item: ItemGroup => ItemGroup( item + newItem) }
    val tree = TreeSet[ItemGroup](newValues.toSeq:_*)(ItemSetOrdering)
    new KnapsackData(limit( tree ) )
  }

  override def toString(): String = {
    values.mkString("\n")
  }
}

/**
 * Mutable
 *
 * Holds results of running the knapsack algorithm.
 * Assumes that we are working with a list of Knapsack items. "n" represents the index of an item in that list.
 *
 * After running the algorithm,
 * each cell (n,w) will represents the most probable combinations of items (less than or equal to n)
 * that exactly match the weight w.
 *
 * @param numItems number of KnapsackItems we are working with
 * @param weight weight that we want to know
 */
class Knapsack(numItems: Int, weight: Int ) {

  private val grid = Array.ofDim[KnapsackData](numItems, weight + 1)

  def apply(itemNum: Int, weight: Int): KnapsackData = {
    if (grid(itemNum)(weight) == null) {
      grid(itemNum)(weight) = KnapsackData()
    }
    grid(itemNum)(weight)
  }

  def update(itemNum: Int, weight: Int, value: KnapsackData) = {
    grid(itemNum)(weight) = value
  }
  
  def result() = {
    grid(numItems - 1)(weight)
  }
}

object Knapsack {

  def sumWeight(items: Traversable[KnapsackItem]) = items.foldLeft(0){ _ + _.weight}

  /**
   * 0/1 Knapsack algorithm see: http://en.wikipedia.org/wiki/Knapsack_problem
   */
  def calculate(items: Seq[KnapsackItem], maxWeight: Int):Knapsack = {

    val results = new Knapsack(items.size, maxWeight)

    for(i <- 1 until items.size;
        j <- 0 to maxWeight) {

      val item = items(i)
      val weight = items(i).weight

      if (weight > j) {
        results(i, j) = results(i-1, j)
      }
      else if (weight == j) {
        val prev = results(i-1, j)
        results(i, j) = prev.add(item)
      }
      else if (weight < j) {
        val prev = results(i-1, j- weight)
        results(i, j) = prev.insert(item).add(results(i-1, j))
      }
    }
    
    results
  }
  
}

