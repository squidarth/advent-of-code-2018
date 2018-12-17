//import scala.io.{Source, BufferedSource}
//import scala.collection.immutable.Set
//import scala.collection.immutable.Vector
//import scala.annotation.tailrec
//
//object Main {
//  def getWordScore(s: String) : (Int, Int) = {
//    val charCounts = s.groupBy(identity).mapValues(_.size)
//    val countSet = charCounts.values.toSet
//
//    def convertBoolToInt(b: Boolean) : Int = {
//      b match {
//        case true => 1
//        case false => 0
//      }
//    }
//    (convertBoolToInt(countSet.contains(2)),
//     convertBoolToInt(countSet.contains(3)))
//  }
//
//  def getTotalScore(wordCounts: Seq[(Int, Int)]) : Int = {
//    val finalScore = wordCounts.fold((0,0)) { (totalSum, individualScore) =>
//      (totalSum._1 + individualScore._1, totalSum._2 + individualScore._2)
//    }
//
//    finalScore match {
//      case (twoSum, threeSum) => twoSum * threeSum
//    }
//  }
//
//  def wordCounter(iter: Iterator[String]) : Seq[(Int, Int)] = {
//    iter.toList.map { s =>
//      getWordScore(s)
//    }.toSeq
//  }
//
//  def main (args: Array[String]) : Unit = {
//    val src = Source.fromFile("day_2_input")
//
//    val wordCounts = wordCounter(src.getLines)
//    println(getTotalScore(wordCounts))
//  }
//}
