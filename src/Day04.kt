fun main() {
    fun part1(input: List<String>): Int {
        val rows = input.filter { it != "" }
        val numbers = rows[0].split(",").map { it.toInt() }
        val cardsWithoutHeader = rows.subList(1, rows.size)
        val cards = cardsWithoutHeader.chunked(5).map { Card(it) }

        numbers.forEach { number ->
            cards.forEach { card ->
                val luckyNumbers = card.checkNumber(number)
                if (luckyNumbers.isNotEmpty()) {
                    return card.unmarkedNumbers().sum() * number
                }
            }
        }
        return 0
    }

    fun part2(input: List<String>): Int {
        val rows = input.filter { it != "" }
        val numbers = rows[0].split(",").map { it.toInt() }
        val cardsWithoutHeader = rows.subList(1, rows.size)
        val cards = cardsWithoutHeader.chunked(5).map { Card(it) }

        val winningCards: MutableSet<Card> = mutableSetOf()

        numbers.forEach { number ->
            cards.forEach { card ->
                val luckyNumbers = card.checkNumber(number)
                if (luckyNumbers.isNotEmpty()) {
                    winningCards.add(card)
                }
                if (winningCards.size == cards.size){
                    return card.unmarkedNumbers().sum() * number
                }
            }
        }


        return 0
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 4512)
    check(part2(testInput) == 1924)

    val input = readInput("Day04")
    check(part1(input) == 11536)
    println(part2(input))
}

class Card(numbers: List<String>) {
    private val rows: MutableList<List<Int>> = mutableListOf()
    private val luckyNumbers: MutableList<Int> = mutableListOf()

    init {
        for (row in numbers) {
            val split = row.split(" ").filter { it != "" }
            rows.add(split.map { it.toInt() })
        }

        repeat(5) { index ->
            run {
                val vertical: MutableList<Int> = mutableListOf()
                for (row in numbers) {
                    vertical.add(row.split(" ").filter { it != "" }[index].toInt())
                }
                rows.add(vertical)
            }
        }
    }

    fun checkNumber(number: Int): List<Int> {
        luckyNumbers.add(number)

        for (row in rows) {
            if (luckyNumbers.containsAll(row)) {
                return row
            }
        }
        return listOf()
    }

    fun unmarkedNumbers(): List<Int> {
        val unmarkedNumbers: MutableList<Int> = mutableListOf()
        for (row in rows.subList(0, 5)) {
            unmarkedNumbers.addAll(row.filter { !luckyNumbers.contains(it) })
        }
        return unmarkedNumbers
    }
}

