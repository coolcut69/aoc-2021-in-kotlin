fun main() {
    fun updateNumbersByOne(input: MutableList<List<Int>>): MutableList<List<Int>> {
        val numbers = mutableListOf<List<Int>>()
        for (row in input) {
            numbers.add(row.map { it +1 })
        }
        return numbers
    }

    fun checkForFlashes(input: MutableList<List<Int>>): MutableList<List<Int>> {
        val numbers = mutableListOf<List<Int>>()
        for (row in input) {
            numbers.add(row.map { it +1 })
        }
        return numbers

    }

    fun part1(input: List<String>): Int {
        var numbers = mutableListOf<List<Int>>()

        for ((rowIndex, row) in input.withIndex()) {

            for ((index, value) in row.withIndex()) {
                println("$value at $rowIndex ,$index")
            }
        }


        for (row in input) {
//            Octopus(    )

            numbers.add(row.map { it.digitToInt() })
        }

        numbers = updateNumbersByOne(numbers)
        numbers = checkForFlashes(numbers)


//        println(numbers)


        return 0
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day11_test")
    check(part1(testInput) == 0)
    check(part2(testInput) == 0)

    val input = readInput("Day11")
//    println(part1(input))
//    println(part2(input))
}


