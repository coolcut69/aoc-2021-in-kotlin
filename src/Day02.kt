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
        val instructions = input.map { SubInstruction(it.split(" ").toTypedArray()) }

        val submarine = Submarine()

        for (instruction in instructions) {
            submarine.move(instruction)
        }

        return submarine.horizontalPosition * submarine.depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
//    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

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
    var aim = 0

    fun move(instruction: SubInstruction) {
        when (instruction.type) {
            "down" -> goDown(instruction.size)
            "up" -> goUp(instruction.size)
            "forward" -> goForward(instruction.size)
        }
    }

    private fun goForward(size: Int) {
        horizontalPosition += size
        adjustAim(size)
    }

    private fun adjustAim(size: Int) {
        if (aim != 0) {
            depth += aim * size
        }
    }

    private fun goUp(size: Int) {
        aim -= size
    }

    private fun goDown(size: Int) {
        aim += size
    }
}

