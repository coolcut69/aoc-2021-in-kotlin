fun main() {
    fun part1(input: List<String>, days: Int): Int {
        val map = input[0].split(",").map { it.toInt() }.map { Lanternfish(it, true) }
        val fishes: MutableList<Lanternfish> = ArrayList(map)

        repeat(days) {
            val newFishes = fishes.count { it.age == 0 }
            repeat(newFishes) {
                fishes.add(Lanternfish(8, false))
            }
            fishes.map { fish -> fish.age() }
        }
        return fishes.count()
    }

    fun part2(input: List<String>, days: Int): Long {
        return 0
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput, 80) == 5934)
//    check(part2(testInput, 256) == 26984457539)

    val input = readInput("Day06")
    println(part1(input, 80))
//    println(part2(input, 256))
}

class Lanternfish(var age: Int, var canAge: Boolean) {

    fun age() {
        when {
            age == 0 -> age = 6
            canAge -> age--
            else -> canAge = true
        }
    }
}
