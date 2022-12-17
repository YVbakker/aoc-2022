import scala.io.Source

@main def run: Unit = {
  val fileName = "input.txt"
  val lines = Source.fromFile(fileName).getLines().toList
  val backpacks = lines.map(line => {
    val (first, second) = line.splitAt(line.length() / 2)
    BackPack(first.toCharArray(), second.toCharArray())
  })
  val sortedBackpacks =
    backpacks.map(bp => BackPack(bp.left.sorted, bp.right.sorted))

  val duplicateItems =
    sortedBackpacks.flatMap(bp => bp.left.find(i => BinarySearch(bp.right, i)))
  val itemPriorities = duplicateItems.map(getItemPriority)
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
