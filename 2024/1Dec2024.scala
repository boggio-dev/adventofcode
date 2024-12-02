import scala.io.Source

object DistanceCalculator {
    def main(args: Array[String]): Unit = {
        val lines = Source.fromFile("input.txt").getLines().toSeq
        
        val (left, right) = lines.map { line =>
            val parts = line.trim.split("\\s+")
        
            (parts(0).toInt, parts(1).toInt)
        }.unzip

        val sortedLeft = left.sorted
        val sortedRight = right.sorted

        // Part 1
        val totalDistance = calculateDistances(sortedLeft, sortedRight)

        println(totalDistance)
    }

    def calculateDistances(sortedLeft: Seq[Int], sortedRight: Seq[Int]): Int = {
        sortedLeft
        .zip(sortedRight)
        .map { case (l, r) => math.abs(l - r) }
        .sum
    }
}
