package aoc2022.day2_1

import scala.io.Source

@main def run: Unit = {
  val fileName = "inputs/day2.txt"
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

val beats = Map(
  'X' -> 'B',
  'Y' -> 'C',
  'Z' -> 'A',
  'A' -> 'Y',
  'B' -> 'Z',
  'C' -> 'X'
)

def parseMove(in: Char): Int = in match
  case 'X' => 1
  case 'Y' => 2
  case 'Z' => 3
  case 'A' => 1
  case 'B' => 2
  case 'C' => 3

def scoreRound(in: Array[Char]): Int = {
  val p1 = in.head
  val p2 = in.last

  val moveScore = parseMove(p2)

  if (beats(p1) == p2)
  {
    return moveScore + 6
  }
  if (beats(p2) != p1) {
    return moveScore + 3
  }
  return moveScore
}