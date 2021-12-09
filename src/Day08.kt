fun main() {
    fun part1(input: List<String>): Int {

        val map: List<String> = input.map { it.split(" | ")[1] }
        var count = 0
        for (numbers in map){
            count +=
                numbers.split(" ").filter { it.length == 2 || it.length == 4 || it.length == 7 || it.length == 3 }
                    .count()

        }
        return count
    }

    fun part2(input: List<String>): Int {
        return 0
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day08_test")
    check(part1(testInput) == 26)
    check(part2(testInput) == 0)

    val input = readInput("Day08")
    println(part1(input))
//    println(part2(input))
}

