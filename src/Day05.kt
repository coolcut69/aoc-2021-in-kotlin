fun main() {
    fun part1(input: List<String>): Int {
        val segments: List<Segment> = input.map { it.split(" -> ") }.map { Segment(it) }
        val straightSegments = segments.filter { it.straightLine() }
        val points = straightSegments.flatMap { it.straightPoints() }
        return points.groupingBy { it }.eachCount().filter { it.value > 1 }.size
    }

    fun part2(input: List<String>): Int {
        val segments: List<Segment> = input.map { it.split(" -> ") }.map { Segment(it) }
        val straightSegments = segments.filter { it.straightLine() }
        val diagonalSegments = segments.filter { !it.straightLine() }
        val straightPoints = straightSegments.flatMap { it.straightPoints() }
        val diagonalPoints = diagonalSegments.flatMap { it.diagonalPoints() }

        val points = straightPoints + diagonalPoints

        return points.groupingBy { it }.eachCount().filter { it.value > 1 }.size
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == 5)
    check(part2(testInput) == 12)

    val input = readInput("Day05")
    check(part1(input) == 7438)
    check(part2(input) == 21406)
}

class Segment(line: List<String>) {
    private val x1 = line[0].split(",")[0].toInt()
    private val y1 = line[0].split(",")[1].toInt()
    private val x2 = line[1].split(",")[0].toInt()
    private val y2 = line[1].split(",")[1].toInt()

    override fun toString(): String {
        return "Segment(x1=$x1, y1=$y1, x2=$x2, y2=$y2)"
    }

    fun straightLine(): Boolean {
        return x1 == x2 || y1 == y2
    }

    fun straightPoints(): List<String> {
        val result: MutableList<String> = ArrayList()
        result.addAll(calculateHorizontalPoints())
        result.addAll(calculateVerticalPoints())
        return result
    }

    fun diagonalPoints(): List<String> {
        val result: MutableList<String> = ArrayList()
        if (x1 > x2 && y1 > y2) {
            for (i in 0 ..x1 - x2) {
                val x = x1 - i
                val y = y1 - i
                result.add("$x,$y")
            }
        }
        if (x1 > x2 && y1 < y2) {
            for (i in 0..x1 - x2) {
                val x = x1 - i
                val y = y1 + i
                result.add("$x,$y")
            }
        }
        if (x2 > x1 && y2 > y1) {
            for (i in 0 ..x2 - x1) {
                val x = x1 + i
                val y = y1 + i
                result.add("$x,$y")
            }
        }
        if (x2 > x1 && y2 < y1) {
            for (i in 0 ..x2 - x1) {
                val x = x1 + i
                val y = y1 - i
                result.add("$x,$y")
            }
        }

        return result
    }

    private fun calculateVerticalPoints(): List<String> {
        val result: MutableList<String> = ArrayList()

        if (y1 == y2) {
            for (i in x1..x2) {
                result.add("$i,$y1")
            }
            for (i in x2..x1) {
                result.add("$i,$y1")
            }
        }
        return result
    }

    private fun calculateHorizontalPoints(): List<String> {
        val result: MutableList<String> = ArrayList()

        if (x1 == x2) {
            for (i in y1..y2) {
                //                println("$x1,$i")
                result.add("$x1,$i")
            }
            for (i in y2..y1) {
                //                println("$x1,$i")
                result.add("$x1,$i")
            }
        }
        return result
    }


}

