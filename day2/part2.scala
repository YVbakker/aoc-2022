import scala.io.Source

@main def run: Unit = {
  val fileName = "input.txt"
  val lines = Source.fromFile(fileName).getLines().toList
  val rounds = lines.map(parseRound)
  val scores = rounds.map(scoreRound)
  println(scores.sum)
}

/** Parses a Round String in the format "A B" as a Char array of [A,B]
  *
  * @param in
  * @return
  */
def parseRound(in: String): Array[Char] = in.split(" ").map(s => s(0))

val wins = Map(
  'A' -> 'C',
  'B' -> 'A',
  'C' -> 'B'
)
val beats = Map(
  'A' -> 'B',
  'B' -> 'C',
  'C' -> 'A'
)

def parseMove(in: Char): Int = in match
  case 'A' => 1
  case 'B' => 2
  case 'C' => 3

def scoreRound(in: Array[Char]): Int = {
  val move = in.head
  val outcome = in.last

  outcome match
    case 'X' => parseMove(wins(move))
    case 'Y' => parseMove(move) + 3
    case 'Z' => parseMove(beats(move)) + 6
}
