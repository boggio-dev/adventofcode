import scala.io.Source

object DistanceCalculator {
    def main(args: Array[String]): Unit = {
        val lines = Source.fromFile("input.txt").getLines().toSeq
        
        val (left, right) = lines.map { line =>
            val parts = line.trim.split("\\s+")
        
            (parts(0).toInt, parts(1).toInt)
        }.unzip

        val distances = calculateDistances(left, right)

        println(distances)
    }

    def calculateDistances(left: Seq[Int], right: Seq[Int]): Seq[Int] = {
        left.zip(right).map { 
            case (left, right) =>
                if (left == right) {
                    0
                } else {
                    val sortedLeft = left.toString.map(_.asDigit).sorted
                    val sortedRight = right.toString().map(_.asDigit).sorted

                    sortedLeft.zip(sortedRight).foldLeft(0) { (acc, pair) =>
                        acc + math.abs(pair._1 - pair._2)
                    }
                }
        }
    }
}
