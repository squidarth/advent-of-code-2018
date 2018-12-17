import scala.io.{Source}
import scala.collection.immutable.Set

object Main {
  def hammingDistance(str1: String, str2: String) : Int = {
    str1.zip(str2).map {
      case (a,b) if a == b => 0
      case _ => 1
    }.sum
  }

  def getCommonChars(str1: String, str2: String) : String = {
    str1.zip(str2).filter {
      case (a, b) => a == b
    }.map {
      case (a, b) => a
    }.mkString
  }

  def getMatchingString(strList: List[String]) : String = {
    strList.combinations(2).toList.map {
      case List(str1, str2) => (str1, str2) 
    } filter {
      case (str1, str2) => hammingDistance(str1, str2) == 1
    } match {
      case Seq((str1: String, str2: String)) => getCommonChars(str1, str2)
      case _ => throw new Exception("Invalid input")
    }
    
  }

  def main (args: Array[String]) : Unit = {
    val src = Source.fromFile("day_2_input")
    println(getMatchingString(src.getLines.toList))
  }
}
