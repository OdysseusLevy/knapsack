/**
 * Electoral college values
 * 
 * Values are from Nate Silver's final forecast for the 2012 presidential election
 * http://fivethirtyeight.blogs.nytimes.com/fivethirtyeights-2012-forecast/
 * 
 * 1.0 represents a 100% chance of Democrat victory
 * .001 represents a 0% chance of Democrat victory (making it nonzero lets me explore the map for Republicans)
 * Note that I replaced 0% chance 
 * Probabilities
 */
object StateData {

	val States2012 = Seq(
    KnapsackItem("Empty", 0),
    KnapsackItem("Alabama",  9, .001),
    KnapsackItem("Alaska",  3, .001),
    KnapsackItem("Arizona", 11, .02),
    KnapsackItem("Arkansas", 6, .001),
    KnapsackItem("California", 55, 1.0),
    KnapsackItem("Colorado",  9, .8),
    KnapsackItem("Connecticut",  7, 1.0),
    KnapsackItem("Delaware",  3, 1.0),
    KnapsackItem("District of Columbia",  3, 1.0),
    KnapsackItem("Florida",  29, .5),
    KnapsackItem("Georgia",  16, .001),
    KnapsackItem("Hawaii",  4, 1.0),
    KnapsackItem("Idaho",  4, .001),
    KnapsackItem("Illinois",  20, 1.0),
    KnapsackItem("Indiana",  11, .001),
    KnapsackItem("Iowa",  6, .84),
    KnapsackItem("Kansas",  6, .001),
    KnapsackItem("Kentucky",  8, .001),
    KnapsackItem("Louisiana",  8, .001),

    // Even though Maine splits its electoral vote, for now let's treat it as monolithic
    KnapsackItem("Maine CD1",  1, 1.0),
    KnapsackItem("Maine CD2",  1, .95),
    KnapsackItem("Maine state", 2, 1.0),
    KnapsackItem("Maryland",  10, 1.0),
    KnapsackItem("Massachusetts",  11, 1.0),
    KnapsackItem("Michigan",  16, .99),
    KnapsackItem("Minnesota",  10, 1.0),
    KnapsackItem("Mississippi",  6, .001),
    KnapsackItem("Missouri",  10, .001),
    KnapsackItem("Montana",  3, .02),
    KnapsackItem("Nebraska CD1",  1, .001),
    KnapsackItem("Nebraska CD2",  1, .13),
    KnapsackItem("Nebraska CD3",  1, .001),
    KnapsackItem("Nebraska state", 2, .001),
    KnapsackItem("Nevada",  6, .518),
    KnapsackItem("New Hampshire",  4, .85),
    KnapsackItem("New Jersey",  14, 1.0),
    KnapsackItem("New Mexico",  5, .99),
    KnapsackItem("New York",  29, 1.0),
    KnapsackItem("North Carolina",  15, .26),
    KnapsackItem("North Dakota",  3, .001),
    KnapsackItem("Ohio",  18, .91 ),
    KnapsackItem("Oklahoma",  7, .001),
    KnapsackItem("Oregon",  7, 1.0),
    KnapsackItem("Pennsylvania",  20, .99),
    KnapsackItem("Rhode Island",  4, 1.0),
    KnapsackItem("South Carolina",  9, .001),
    KnapsackItem("South Dakota",  3, .001),
    KnapsackItem("Tennessee",  11, .001),
    KnapsackItem("Texas",  38, .001),
    KnapsackItem("Utah",  6, .001),
    KnapsackItem("Vermont",  3, 1.0),
    KnapsackItem("Virginia",  13, .79),
    KnapsackItem("Washington",  12, 1.0),
    KnapsackItem("West Virginia",  5, .001),
    KnapsackItem("Wisconsin",  10, .97),
    KnapsackItem("Wyoming",  3, .001)
  )
}
