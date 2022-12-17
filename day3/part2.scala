import scala.io.Source

@main def run: Unit = {
  val fileName = "input.txt"
  val lines = Source.fromFile(fileName).getLines().toList.map(_.toCharArray())
  val groups = lines.grouped(3).toList
  val sortedGroups = for group <- groups yield group.map(_.sorted)
  val smallestBackpackFirst =
    for group <- sortedGroups yield group.sortWith(_.length < _.length)
  val badges = smallestBackpackFirst.flatMap(group =>
    group.head.find(i => {
      BinarySearch(group(1), i) && BinarySearch(group.last, i)
    })
  )
  val itemPriorities = badges.map(getItemPriority)
  println(itemPriorities.sum)
}

val items = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()

def getItemPriority(in: Char): Int = items.indexOf(in) + 1

case class BackPack(left: Array[Char], right: Array[Char]) {}

def BinarySearch(arr: Array[Char], elem: Char): Boolean = {
  def Search(
      arr: Array[Char],
      elem: Char,
      low: Int,
      high: Int
  ): Boolean = {

    if (low > high)
      return false

    var middle = low + (high - low) / 2

    arr match {
      case (arr: Array[Char])
          if (arr(middle) ==
            elem) =>
        return true

      case (arr: Array[Char])
          if (arr(middle) <
            elem) =>
        Search(arr, elem, middle + 1, high)

      case (arr: Array[Char])
          if (arr(middle) >
            elem) =>
        Search(arr, elem, low, middle - 1)
    }
  }
  Search(arr, elem, 0, arr.length - 1)
}
