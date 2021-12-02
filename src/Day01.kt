fun main() {
    fun part1(input: List<String>): Int {
        val numbers = input.map(String::toInt)
        return numbers.windowed(2).count { (a, b) -> b > a }
    }

    fun part2(input: List<String>): Int {
        val numbers = input.map(String::toInt)
        return numbers.windowed(3).windowed(2).count { (a, b) -> b.sum() > a.sum() }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

