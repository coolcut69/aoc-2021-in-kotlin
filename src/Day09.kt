fun main() {
    fun checkFirstRow(row: String, afterRow: String): MutableList<Int> {
        val lowPoints = mutableListOf<Int>()
        for ((index, point) in row.withIndex()) {
            if (index == 0) {
                val belowValue = afterRow[index].digitToInt()
                val rightValue = row[index + 1].digitToInt()
                val value = point.digitToInt()

                if (value < rightValue && value < belowValue) {
                    lowPoints.add(value)
                }
            } else if (index + 1 == row.length) {
                val belowValue = afterRow[index].digitToInt()
                val leftValue = row[index - 1].digitToInt()
                val value = point.digitToInt()

                if (value < leftValue && value < belowValue) {
                    lowPoints.add(value)
                }
            } else {
                val belowValue = afterRow[index].digitToInt()
                val rightValue = row[index + 1].digitToInt()
                val leftValue = row[index - 1].digitToInt()
                val value = point.digitToInt()

                if (value < rightValue && value < belowValue && value < leftValue) {
                    lowPoints.add(value)
                }
            }
        }
        return lowPoints
    }

    fun check(beforeRow: String, row: String, afterRow: String): MutableList<Int> {
        val lowPoints = mutableListOf<Int>()
        for ((index, point) in row.withIndex()) {
            if (index == 0) {
                val aboveValue = beforeRow[index].digitToInt()
                val belowValue = afterRow[index].digitToInt()
                val rightValue = row[index + 1].digitToInt()
                val value = point.digitToInt()

                if (value < rightValue && value < aboveValue && value < belowValue) {
                    lowPoints.add(value)
                }
            } else if (index + 1 == row.length) {
                val aboveValue = beforeRow[index].digitToInt()
                val belowValue = afterRow[index].digitToInt()
                val leftValue = row[index - 1].digitToInt()
                val value = point.digitToInt()

                if (value < leftValue && value < aboveValue && value < belowValue) {
                    lowPoints.add(value)
                }
            } else {
                val aboveValue = beforeRow[index].digitToInt()
                val belowValue = afterRow[index].digitToInt()
                val rightValue = row[index + 1].digitToInt()
                val leftValue = row[index - 1].digitToInt()
                val value = point.digitToInt()

                if (value < rightValue && value < aboveValue && value < leftValue && value < belowValue) {
                    lowPoints.add(value)
                }
            }
        }
        return lowPoints
    }

    fun checkLastRow(beforeRow: String, row: String): MutableList<Int> {
        val lowPoints = mutableListOf<Int>()
        for ((index, point) in row.withIndex()) {
            if (index == 0) {
                val aboveValue = beforeRow[index].digitToInt()
                val rightValue = row[index + 1].digitToInt()
                val value = point.digitToInt()

                if (value < rightValue && value < aboveValue) {
                    lowPoints.add(value)
                }
            } else if (index + 1 == row.length) {
                val aboveValue = beforeRow[index].digitToInt()
                val leftValue = row[index - 1].digitToInt()
                val value = point.digitToInt()

                if (value < leftValue && value < aboveValue) {
                    lowPoints.add(value)
                }
            } else {
                val aboveValue = beforeRow[index].digitToInt()
                val rightValue = row[index + 1].digitToInt()
                val leftValue = row[index - 1].digitToInt()
                val value = point.digitToInt()

                if (value < rightValue && value < aboveValue && value < leftValue) {
                    lowPoints.add(value)
                }
            }
        }
        return lowPoints
    }

    fun part1(input: List<String>): Int {
        val lowPoints = mutableListOf<Int>()
        for ((index, value) in input.withIndex()) {
            if (index == 0) {
                lowPoints.addAll(checkFirstRow(value, input[index + 1]))
            } else if (index + 1 == input.size) {
                lowPoints.addAll(checkLastRow(input[index - 1], value))
            } else {
                lowPoints.addAll(check(input[index - 1], value, input[index + 1]))
            }
        }
        return lowPoints.sumOf { it + 1 }
    }

    fun part2(input: List<String>): Int {
        return 0
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day09_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 0)

    val input = readInput("Day09")
    check(part1(input) == 462)
//    println(part2(input))
}

