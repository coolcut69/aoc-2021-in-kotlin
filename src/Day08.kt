import kotlin.ranges.CharRange.Companion.EMPTY

fun main() {
    fun part1(input: List<String>): Int {
        val map: List<String> = input.map { it.split(" | ")[1] }
        var count = 0
        for (numbers in map) {
            count +=
                numbers.split(" ").count { it.length == 2 || it.length == 4 || it.length == 7 || it.length == 3 }
        }
        return count
    }

    fun checkValue(value: String): Number {
        return if (Number.TWO.value == value) {
            Number.TWO
        } else if (Number.THREE.value == value) {
            Number.THREE
        } else if (Number.FIVE.value == value) {
            Number.FIVE
        } else if (Number.NINE.value == value) {
            Number.NINE
        } else if (Number.SIX.value == value) {
            Number.SIX
        } else {
            Number.ZERO
        }
    }

    fun toNumber(it: String): Int {
        val value = it.toCharArray().apply { sort() }.joinToString("")
        val number = when (value.length) {
            2 -> Number.ONE
            3 -> Number.SEVEN
            4 -> Number.FOUR
            7 -> Number.EIGHT
            else -> checkValue(value)
        }
        return number.numValue
    }

    fun calculateNumber(row: String): MutableList<String> {
        val signal =
            row.split(" | ")[0]//.split(" ").filter { it.length == 2 || it.length == 4 || it.length == 7 || it.length == 3 }
        val output = row.split(" | ")[1]

        val one = signal.split(" ").first { it.length == 2 }.toCharArray().apply { sort() }.joinToString("")
        val four = signal.split(" ").first { it.length == 4 }.toCharArray().apply { sort() }.joinToString("")
        val identifyFive = four.removeAllChar(one)
        val identifySix = four.removeAllChar(one)

        val numbers = mutableListOf<String>()

        for (number in output.split(" ")) {
            if (number.length == 2) {
                numbers.add("1")
            }
            if (number.length == 4) {
                numbers.add("4")
            }
            if (number.length == 3) {
                numbers.add("7")
            }
            if (number.length == 7) {
                numbers.add("8")
            }
            if (number.length == 5) {
                if (number.containsNumber(one)) {
                    numbers.add("3")
                } else if (number.containsNumber(identifyFive)) {
                    numbers.add("5")
                } else {
                    numbers.add("2")
                }
            }
            if (number.length == 6) {
                if (number.containsNumber(four)) {
                    numbers.add("9")
                } else if (!number.containsNumber(identifySix)) {
                    numbers.add("0")
                } else {
                    numbers.add("6")
                }
            }
        }
//        println(numbers)
        return numbers
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        for (row in input) {
            sum += calculateNumber(row).joinToString("").toInt()
        }
        return sum
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day08_test")
    check(part1(testInput) == 26)
    check(part2(testInput) == 61229)

    val input = readInput("Day08")
    check(part1(input) == 381)
    check(part2(input) == 1023686)
}

private fun String.removeAllChar(one: String): String {
    var output = this
    for (c: Char in one){
        output = output.replace(c, newChar = EMPTY.first)
    }
    return output
}

private fun String.containsNumber(one: String): Boolean {
    for (c in one){
        if (c.isLowerCase() && !this.contains(c)) {
            return false
        }
    }
    return true
}

private enum class Number(val value: String, val numValue: Int) {
    ZERO("abcdeg", 0),
    ONE("ab", 1),
    TWO("acdfg", 2),
    THREE("abcdf", 3),
    FOUR("abef", 4),
    FIVE("bcdef", 5),
    SIX("bcdefg", 6),
    SEVEN("abd", 7),
    EIGHT("abcdefg", 8),
    NINE("abcdef", 9)
}
