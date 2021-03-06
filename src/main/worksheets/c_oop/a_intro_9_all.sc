/**
 * Scala is object-oriented and it's always like...write less do more :)
 */
class AClass

val d = new AClass

val isAny = d.isInstanceOf[Any]

class BClass extends AClass

val isA = new BClass().isInstanceOf[AClass]
val isB = new BClass().isInstanceOf[BClass]

import scala.util.Random

/**
 * Class with field and methods
 */
class Lunch {
  private val food = Seq("Pizza", "Sushi", "Burger")

  // Public API should have return type
  def decide(): String = food(Random.nextInt(food.size))

}

val lunch = new Lunch().decide()
