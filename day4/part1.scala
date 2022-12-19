import scala.io.Source

@main def run: Unit = {
  val fileName = "input.txt"
  val lines = Source.fromFile(fileName).getLines().toList
  val pairs = lines.map(l => {
    l.split(',')
    .map(e => {
      e.split('-')
      .map(_.toInt)
    })
    .map(e => Elf(e.head, e.last))
    .toList
  })

  val sectionsContained = pairs.map(p => {
    val first = p.head
    val second = p.last
    
    if (first.start >= second.start) && (first.end <= second.end) then true
    else if (second.start >= first.start) && (second.end <= first.end) then true
    else false
  })

  println(sectionsContained.count(i => i))
}

case class Elf(start: Int, end: Int)