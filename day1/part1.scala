import scala.io.Source

@main def run: Unit = {
  val fileName = "input.txt"
  val lines = Source.fromFile(fileName).getLines().toList
  val calsPerElf = getListOfCaloriesPerElf(lines)
  println(calsPerElf.max)
}

def getListOfCaloriesPerElf(in: List[String]): List[Int] = {
  val elves = split(in)
  val numericElves = for elf <- elves yield for line <- elf yield line.toInt
  val summedElves = for elf <- numericElves yield elf.sum
  summedElves
}

def split(
    in: List[String],
    next: List[String] = Nil,
    out: List[List[String]] = Nil
): List[List[String]] = in match {
  case Nil          => out.map(_.reverse).reverse
  case "" :: tail   => split(tail, Nil, next :: out)
  case head :: tail => split(tail, head :: next, out)
}
