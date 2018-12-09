import scala.io.{Source, BufferedSource}
import scala.collection.mutable.Set

object CountFrequencies {
  def numberList(src: BufferedSource) : Iterator[Int] = {
    val negRegex = raw"-(\d+)".r
    val posRegex = raw"\+(\d+)".r
    src.getLines.map { s =>
      s match {
        case posRegex(num) => num.toInt
        case negRegex(num) => -(num.toInt)
      }
    }
  }

  def getFrequencySum(src: BufferedSource) : Int = {
    numberList(src).sum
  }

  def getFirstRepeatedFrequency(src: BufferedSource): Int = {
    val set = Set[Int]()
    var sum = 0
    val numList = numberList(src).toList
    for (number <- Stream.continually(numList.toStream).flatten) {
      if (set contains sum) {
        return sum
      } else {
        set += sum
      }
      sum = sum + number
    }
    return 0
  }

  def main (args: Array[String]) : Unit = {
    println(getFirstRepeatedFrequency(Source.fromFile("input")))
//    println(getFrequencySum(Source.fromFile("input")))
//    println(getFrequencySum(Source.fromFile("input")))
  }
}
