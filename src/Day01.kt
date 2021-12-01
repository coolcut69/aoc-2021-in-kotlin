fun main() {
    fun part1(input: List<String>): Int {
        val numbers = input.map(String::toInt)
        var count = 0

        for ((index, value) in numbers.withIndex()) {
            if (index+1  < numbers.size && numbers[index + 1] > value) {
                count++
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        val numbers = input.map(String::toInt)
        val measurements = mutableListOf<ThreePointMeasurement>()

        for ((index, _) in numbers.withIndex()) {
            measurements.add(ThreePointMeasurement(index, numbers))
        }

        var count = 0
        for ((index, value) in measurements.withIndex()) {
            if (index + 1 < numbers.size && measurements[index + 1].numbers.sum() > value.numbers.sum()) {
                count++
            }
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

class ThreePointMeasurement(index: Int, inputList: List<Int>) {
    val numbers = mutableListOf<Int>()

    init {
        numbers.add(inputList[index])
        if (index + 1 < inputList.size) {
            numbers.add(inputList[index + 1])

        }
        if (index + 2 < inputList.size) {
            numbers.add(inputList[index + 2])
        }
    }
}

