/**
 * For case classes extractors for pattern matching are generated
 */
case class Player(name: String, score: Score = null)

case class Score(game: String, score: Int)

val hulk = Player(name = "Hulk", score = Score("Pacman", 3560))

def playerLevel(someGame: String, player: Player) = player match {
  case Player(_, Score(game, score)) if game == someGame && score > 6000 => "Super Hero"
  case Player(_, Score(game, score)) if game == someGame && score > 3000 => "Intermediate"
  case Player(_, Score(game, _)) => "Beginner"
}
val hulkPacmanLevel = playerLevel("Pacman", hulk)

