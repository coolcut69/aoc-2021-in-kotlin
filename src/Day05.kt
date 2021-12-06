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
    println(part2(input))
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
        if (x1 > x2 && y1 > y2){
            println("x1 > x2 && y1 > y2")
            println(this)
            result.add("8,0")
            result.add("7,1")
            result.add("6,2")
            result.add("5,3")
            result.add("4,4")
            result.add("3,5")
            result.add("2,6")
            result.add("1,7")
            result.add("0,8")
        }
        if (x1 > x2 && y1 < y2){
            println("x1 > x2 && y1 < y2")
            println(this)
            result.add("6,4")
            result.add("5,3")
            result.add("4,2")
            result.add("3,1")
            result.add("2,0")
        }
        if (x2 > x1 && y2 > y1){
            println("x2 > x1 && y2 > y1")
            println(this)
            result.add("0,0")
            result.add("1,1")
            result.add("2,2")
            result.add("3,3")
            result.add("4,4")
            result.add("5,5")
            result.add("6,6")
            result.add("7,7")
            result.add("8,8")
        }
        if (x2 > x1 && y2 < y1){
            println("x2 > x1 && y2 < y1")
            println(this)
            result.add("5,5")
            result.add("6,4")
            result.add("7,3")
            result.add("8,2")

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

