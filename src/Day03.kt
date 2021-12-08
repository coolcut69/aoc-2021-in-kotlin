fun main() {
    fun part1(input: List<String>): Int {
        var gammaString = ""
        var epsilonString = ""

        for (i   in 0 until input[0].length) {
            val list = input.map { it[i] }
            val mostCommonDigit = list.groupBy { it }
                .maxByOrNull { it.value.size }
                ?.key
            val lessCommonDigit = list.groupBy { it }
                .minByOrNull { it.value.size }
                ?.key
            gammaString += mostCommonDigit
            epsilonString += lessCommonDigit
        }
        return gammaString.toInt(2) * epsilonString.toInt(2)
    }

    fun part2(input: List<String>): Int {
        val oxygenList = mutableListOf<String>()
        oxygenList.addAll(input)

        for (i in 0 until input[0].length) {
            val list = oxygenList.map { it[i] }
            var mostCommonDigit = list.groupBy { it }
                .maxByOrNull { it.value.size }
                ?.key

            if ((list.groupBy { it }['0']?.size == list.groupBy { it }['1']?.size)) {
                mostCommonDigit = '1'
            }

            oxygenList.removeIf { it[i] != mostCommonDigit }
        }
        val oxygen: Int = oxygenList[0].toInt(2)

        val co2List = mutableListOf<String>()
        co2List.addAll(input)

        for (i in 0 until input[0].length) {
            val list = co2List.map { it[i] }
            var lessCommonDigit = list.groupBy { it }
                .minByOrNull { it.value.size }
                ?.key

            if ((list.groupBy { it }['0']?.size == list.groupBy { it }['1']?.size)) {
                lessCommonDigit = '0'
            }

            co2List.removeIf { it[i] != lessCommonDigit }

        }
        val co2: Int = co2List[0].toInt(2)
        return oxygen * co2
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

