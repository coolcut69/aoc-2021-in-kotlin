fun main() {
    fun part1(input: List<String>): Int {
        val instructions = input.map { SubInstruction(it.split(" ").toTypedArray()) }

        val submarine = Submarine()

        for (instruction in instructions) {
            submarine.move(instruction)
        }

        return submarine.horizontalPosition * submarine.depth
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 6)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

class SubInstruction(toTypedArray: Array<String>) {

    var type = ""
    var size = 0

    init {
        type = toTypedArray[0]
        size = toTypedArray[1].toInt()
    }

}

class Submarine {
    var horizontalPosition = 0
    var depth = 0

    fun move(instruction: SubInstruction) {
        if (instruction.type == "forward") {
            horizontalPosition += instruction.size
        }
        if (instruction.type == "down") {
            depth += instruction.size
        }
        if (instruction.type == "up") {
            depth -= instruction.size
        }
    }


}

