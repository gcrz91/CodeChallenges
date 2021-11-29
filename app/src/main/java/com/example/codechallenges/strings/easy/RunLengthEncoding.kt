package com.example.codechallenges.strings.easy

/**
Run-Length Encoding

Write a function that takes in a non-empty string and returns its run-length
encoding.

From Wikipedia, "run-length encoding is a form of lossless data compression in
which runs of data are stored as a single data value and count, rather than as
the original run." For this problem, a run of data is any sequence of
consecutive, identical characters. So the run "AAA" would be
run-length-encoded as "3A".

To make things more complicated, however, the input string can contain all
sorts of special characters, including numbers. And since encoded data must be
decodable, this means that we can't naively run-length-encode long runs. For
example, the run "AAAAAAAAAAAA" (12 As), can't
naively be encoded as "12A", since this string can be decoded as
either "AAAAAAAAAAAA" or "1AA". Thus, long runs (runs
of 10 or more characters) should be encoded in a split fashion; the
aforementioned run should be encoded as "9A3A".

Sample Input
string = "AAAAAAAAAAAAABBCCCCDD"

Sample Output
"9A4A2B4C2D"

 **/

fun runLengthEncoding(string: String): String {
    // Write your code here.
    val characters = createCharacterList(string)

    val encodedString = StringBuilder()
    for (char in characters) {
        val character = char.first
        var size = char.second
        generateEncoding(encodedString, character, size)
    }
    return encodedString.toString()
}

fun createCharacterList(string: String): MutableList<Pair<String, Int>> {
    val characters = mutableListOf<Pair<String, Int>>()
    var previousCharacterStartIndex = 0
    var previousCharacter = ""
    for (i in string.indices) {
        val current = string[i].toString()
        if (current != previousCharacter) {
            var difference = (i) - previousCharacterStartIndex
            if (i == string.length) difference += 1
            characters.add(Pair(previousCharacter, difference))
            previousCharacterStartIndex = i
            previousCharacter = current
        }
    }
    // Run for last character
    characters.add(Pair(string[string.length - 1].toString(), string.length - previousCharacterStartIndex))
    return characters
}

fun generateEncoding(strBuilder: StringBuilder, character: String, size: Int) {
    if (size - 9 <= 0 && size != 0) {
        strBuilder.append("$size$character")
        return
    } else if (size > 9) {
        strBuilder.append("9$character")
        generateEncoding(strBuilder, character, size - 9)
    }

}

fun main() {
    println(runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"))
}

// O(n) time | O(n) space - where n is the length of the input array
fun SampleOneRunLengthEncoding(string: String): String {
    // The input string is guaranteed to be non-empty
    // so our first run will be of at least length 1
    val encodedStringCharacters = mutableListOf<Char>()
    var currentRunLength = 1

    for (i in 1 until string.length) {
        val currentCharacter = string[i]
        val previousCharacter = string[i - 1]

        if (currentCharacter != previousCharacter || currentRunLength == 9) {
            encodedStringCharacters.add(currentRunLength.toString()[0])
            encodedStringCharacters.add(previousCharacter)
            currentRunLength = 0
        }

        currentRunLength++
    }

    // Handle the last run
    encodedStringCharacters.add(currentRunLength.toString()[0])
    encodedStringCharacters.add(string[string.length - 1])

    return encodedStringCharacters.joinToString("")
}