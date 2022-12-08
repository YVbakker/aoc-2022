package aoc2022.day2_2

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("example test that succeeds") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }
  test("RockDrawTest") {
    val obtained = scoreRound(Array('A', 'Y'))
    val expected = 4
    assertEquals(obtained, expected)
  }
  test("PaperDrawTest") {
    val obtained = scoreRound(Array('B', 'Y'))
    val expected = 5
    assertEquals(obtained, expected)
  }
  test("ScissorsDrawTest") {
    val obtained = scoreRound(Array('C', 'Y'))
    val expected = 6
    assertEquals(obtained, expected)
  }
  test("RockLoseTest") {
    val obtained = scoreRound(Array('A', 'X'))
    val expected = 3
    assertEquals(obtained, expected)
  }
  test("PaperLoseTest") {
    val obtained = scoreRound(Array('B', 'X'))
    val expected = 1
    assertEquals(obtained, expected)
  }
  test("ScissorsLoseTest") {
    val obtained = scoreRound(Array('C', 'X'))
    val expected = 2
    assertEquals(obtained, expected)
  }
  test("RockWinTest") {
    val obtained = scoreRound(Array('A', 'Z'))
    val expected = 8
    assertEquals(obtained, expected)
  }
  test("PaperWinTest") {
    val obtained = scoreRound(Array('B', 'Z'))
    val expected = 9
    assertEquals(obtained, expected)
  }
  test("ScissorsWinTest") {
    val obtained = scoreRound(Array('C', 'Z'))
    val expected = 7
    assertEquals(obtained, expected)
  }
}
