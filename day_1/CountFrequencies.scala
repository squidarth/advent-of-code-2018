import scala.io.{Source, BufferedSource}
import scala.collection.immutable.Set
import scala.collection.immutable.Vector

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

  def getFirstRepeatedFrequencyRecurse( nums: Vector[Int], currIndex: Int, currSum: Int, seenFreqs: Set[Int]) : Int = {
    (seenFreqs contains currSum) match {
      case true => currSum
      case false => {
        val nextIndex = (currIndex + 1) % nums.length
        val nextSum = currSum + nums(nextIndex)
        getFirstRepeatedFrequencyRecurse(nums, nextIndex, nextSum, seenFreqs + currSum )
      }
    }
  }

  def getFirstRepeatedFrequency(src: BufferedSource): Int = {
    val vec = numberList(src).toVector

    getFirstRepeatedFrequencyRecurse(vec, -1, 0, Set[Int]())

  }

  def main (args: Array[String]) : Unit = {
    println(getFrequencySum(Source.fromFile("input")))
    println(getFirstRepeatedFrequency(Source.fromFile("input")))
  }
}
