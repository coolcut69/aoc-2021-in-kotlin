import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val numbers = input[0].split(",").map { it.toInt() }
        val maxOfOrNull = numbers.maxOfOrNull { it }
        val minOfOrNull = numbers.minOfOrNull { it }

        val fuelComsumption: MutableList<Int> = ArrayList()

        for (i in minOfOrNull!!..maxOfOrNull!!) {
            fuelComsumption.add(numbers.sumOf { abs(it - i) })
        }

        return fuelComsumption.minOrNull()!!
    }

    fun crab(it: Int): Int {
        var sum = 0
        for (i in 1..it) {
            sum += i
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val numbers = input[0].split(",").map { it.toInt() }
        val maxOfOrNull = numbers.maxOfOrNull { it }
        val minOfOrNull = numbers.minOfOrNull { it }

        val fuelComsumption: MutableList<Int> = ArrayList()

        for (i in minOfOrNull!!..maxOfOrNull!!) {
            fuelComsumption.add(numbers.map { abs(it - i) }.sumOf { crab(it) })
        }
        return fuelComsumption.minOrNull()!!
    }


// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    check(part1(testInput) == 37)
    check(part2(testInput) == 168)

    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}

