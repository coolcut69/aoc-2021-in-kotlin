fun main() {
    fun calculateAddition(rules: List<Rule>, template: String): List<Rule> {
        return template.windowed(2).map { rules.first { r -> r.pair == it } }
    }

    fun applyCondition(rules: List<Rule>, template: String): String {
        var change = template

        var count = 1
        for ((index, rule) in rules.withIndex()) {
            change = change.replaceRange(index + count, index + count, rule.insert)
            count++
        }
        return change
    }

    fun part1(input: List<String>): Int {
        val rules = mutableListOf<Rule>()
        for (i in 2 until input.size) {
            rules.add(Rule(input[i].split(" -> ")[0], input[i].split(" -> ")[1]))
        }

        var template: String = input[0]
        repeat(10) {
            val addition = calculateAddition(rules, template)
            template = applyCondition(addition, template)
        }

        var lowestNumber = Int.MAX_VALUE
        var highestNumber = 0

        for (c in template.toCharArray().distinct()) {
            val count = template.count { ch -> ch == c }
            if (count > highestNumber) {
                highestNumber = count
            }
            if (count < lowestNumber) {
                lowestNumber = count
            }
        }
        return highestNumber - lowestNumber
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day14_test")
    check(part1(testInput) == 1588)
    check(part2(testInput) == 0)

    val input = readInput("Day14")
    check(part1(input) == 2947)
    println(part2(input))
}

data class Rule(val pair: String, val insert: String)

fun String.addCharAtIndex(char: String, index: Int) =
    StringBuilder(this).apply { insert(index, char) }.toString()