import scala.util.Random

/**
 * Constructor with parameter aka class parameter
 *
 * @see [[scala.collection.Seq]]
 */
class ConfigurableLunchDecision(choices: Seq[String]) {
  def decide() = choices(Random.nextInt(choices.size))
}

val configured = new ConfigurableLunchDecision(
  Seq(
    "Pasta",
    "Curry Wurst",
    "Sandwich"
  )
).decide()

/**
 * Inheritance and Auxiliary constructors
 */
class LimitedChoicesLunchDecision(choices: Seq[String]) extends ConfigurableLunchDecision(choices) {
  //  Restriction:
  //    The primary constructor must be called from every other constructor
  def this(choice1: String, choice2: String) = {
    this(Seq(choice1, choice2))
  }
}

val limited = new LimitedChoicesLunchDecision("Pasta", "Pizza").decide()

/**
 * Named parameter and default value
 */
class TolerantLunchDecision(choice1: String = "Pasta", choice2: String = "Pizza") {
  def decide() = Seq(choice1, choice2)(Random.nextInt(2))
}

val tolerant = new TolerantLunchDecision(choice2 = "Burger").decide()

/**
 * Constructor with constraints
 */
class NoPastaLunchDecision(val choice: String) {
  if (choice == "Pasta")
    throw new IllegalArgumentException("Oh no ... Pasta again!!!")
}

val noPasta = try {
  new NoPastaLunchDecision("Pasta").choice
} catch {
  case e: IllegalArgumentException => new NoPastaLunchDecision("Pizza").choice
}

/**
 * Getters and setters
 *
 * @param budget Is just a parameter
 * @param restaurant Compiler generates a readable field
 * @param howMany Compiler generates a readable field and a setter
 */
class Reservation(budget: Int, val restaurant: String, var howMany: Int) {
  def getBudget = budget
}

val lunchReservation = new Reservation(250, "Il Ritrovo", 12)

// Without "val" or "var" we just define a parameter. Accessing a parameter does not work.
// lunchReservation.budget
lunchReservation.getBudget

lunchReservation.restaurant

// When "val" no setter is generated. Re-assigning a val is not allowed.
// lunchReservation.restaurant = "murks"

// When parameter is declared as a val, the compiler generates
// a private field corresponding to each parameter (a different internal name is used),
// along with a public reader method that has the same name as the parameter.
// If a parameter has the var keyword, a public writer method is also generated with
// the parameter’s name as a prefix, followed by _= .

lunchReservation.howMany
lunchReservation.howMany = 14
lunchReservation.howMany_=(16)
lunchReservation.howMany

// TODO: define an operator

// FYI: This is what the compiler generates
class Reservation2(budget: Int, val restaurant: String) {
  def getBudget = budget

  private var _howMany = 12

  def howMany = _howMany

  def howMany_=(newBudget: Int) = _howMany = newBudget

}
