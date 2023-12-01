val wordsToDigits = mapOf(
    "zero" to "0",
    "one" to "1",
    "two" to "2",
    "three" to "3",
    "four" to "4",
    "five" to "5",
    "six" to "6",
    "seven" to "7",
    "eight" to "8",
    "nine" to "9"
)

private fun firstDigitFromStart(string: String): String {
    val word = string.findAnyOf(wordsToDigits.keys) ?: (Int.MAX_VALUE to "")
    val digit = string.findAnyOf(wordsToDigits.values) ?: (Int.MAX_VALUE to "")

    return if (word.first > digit.first) {
        digit.second
    } else {
        wordsToDigits[word.second] ?: error("No digit found")
    }
}

private fun firstDigitFromBack(string: String): String {
    val word = string.findLastAnyOf(wordsToDigits.keys) ?: (Int.MIN_VALUE to "")
    val digit = string.findLastAnyOf(wordsToDigits.values) ?: (Int.MIN_VALUE to "")

    return if (word.first < digit.first) {
        digit.second
    } else {
        wordsToDigits[word.second] ?: error("No digit found")
    }
}

fun part1(fileName: String): Int {
    val input = readInput(fileName)

    val sum = input.sumOf { line ->
        val firstNumber = line.first { it.isDigit() }
        val lastNumber = line.last { it.isDigit() }

        "$firstNumber$lastNumber".toInt()
    }

    return sum
}

fun part2(fileName: String): Int {
    val input = readInput(fileName)

    val sum = input.sumOf { line ->
        val firstValue = firstDigitFromStart(line)
        val secondValue = firstDigitFromBack(line)

        "$firstValue$secondValue".toInt()
    }

    return sum
}

fun main() {
    println("Part 1: " + part1("Day01"))
    println("Part 2: " + part2("Day01"))
}
