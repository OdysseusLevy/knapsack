package
/**
 * Using a modified knapsack algorithm, prints out the most likely states to cause a tie. States printed out are assumed
 * to have gone to the Democrats all other states are assumed to have gone to the Republicans.
 *
 * Nate Silver did an interesting write up about this possibility here:
 * http://fivethirtyeight.blogs.nytimes.com/2012/10/01/new-polls-raise-chance-of-electoral-college-tie/?_php=true&_type=blogs&_r=0
 *
 * It is interesting to compare these results to Nate's. They are subtly different than what he came up with
 *
 */
object ElectoralTieCalculator {

  def main(args: Array[String]) {

    val electoralVotes = Knapsack.sumWeight(StateData.States2012)
    val tieVote = electoralVotes/2

    println(s"Electoral college votes: $electoralVotes, tie vote: $tieVote")
    val knapsack = Knapsack.calculate(StateData.States2012, tieVote)

    println(knapsack.result)
  }
}
