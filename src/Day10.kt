fun main() {
    fun part1(input: List<String>): Int {

        val corrupted = mutableListOf<String>()
        for (line in input) {
            var change: String = line

            while (change.contains('}') || change.contains(']') || change.contains('>') || change.contains(')')) {
                change = change.replace("[]", "")
                change = change.replace("{}", "")
                change = change.replace("<>", "")
                change = change.replace("()", "")

//                val numberOfEndChars = change.count { it == '}' } +
//                        change.count { it == ']' } +
//                        change.count { it == '>' } +
//                        change.count { it == ')' }
//                if (numberOfEndChars == 1) {
                    var indexOf = change.indexOf(">")
                    if (indexOf != -1){
                        val possibleOpeningTag = change[indexOf -1]
                        if (possibleOpeningTag == '{' || possibleOpeningTag == '('  || possibleOpeningTag == '[' ){
                            corrupted.add("$possibleOpeningTag>")
                            change = change.replace("$possibleOpeningTag>", "")
                        }
                    }
                    indexOf = change.indexOf("}")
                    if (indexOf != -1){
                        val possibleOpeningTag = change[indexOf -1]
                        if (possibleOpeningTag == '<' || possibleOpeningTag == '('  || possibleOpeningTag == '[' ){
                            corrupted.add("$possibleOpeningTag}")
                            change = change.replace("$possibleOpeningTag}", "")
                        }
                    }
                    indexOf = change.indexOf("]")
                    if (indexOf != -1){
                        val possibleOpeningTag = change[indexOf -1]
                        if (possibleOpeningTag == '{' || possibleOpeningTag == '('  || possibleOpeningTag == '<' ){
                            corrupted.add("$possibleOpeningTag]")
                            change = change.replace("$possibleOpeningTag]", "")
                        }
                    }
                    indexOf = change.indexOf(")")
                    if (indexOf != -1){
                        val possibleOpeningTag = change[indexOf -1]
                        if (possibleOpeningTag == '{' || possibleOpeningTag == '<'  || possibleOpeningTag == '[' ){
                            corrupted.add("$possibleOpeningTag)")
                            change = change.replace("$possibleOpeningTag)", "")
                        }
                    }
            }
        }
        var errors = 0
        for (line in corrupted){
            if (line[1] == ')'){
                errors += 3
            }
            if (line[1] == ']'){
                errors += 57
            }
            if (line[1] == '}'){
                errors += 1197
            }
            if (line[1] == '>'){
                errors += 25137
            }
        }

        return errors
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day10_test")
    check(part1(testInput) == 26397)
    check(part2(testInput) == 0)

    val input = readInput("Day10")
    println(part1(input))
//    println(part2(input))
}


/*

            if (line.count { c -> c == '<' } != line.count { c -> c == '>' }) {
        println("Expected < >")
//                break
    } else if (line.count { c -> c == '[' } != line.count { c -> c == ']' }) {
        println("Expected [ ]")
//                break
    } else if (line.count { c -> c == '{' } != line.count { c -> c == '}' }) {
        println("Expected { }")
//                break
    } else if (line.count { c -> c == '(' } != line.count { c -> c == ')' }) {
        println("Expected ( )")
//                break
    } else {
        println("fine")


 */