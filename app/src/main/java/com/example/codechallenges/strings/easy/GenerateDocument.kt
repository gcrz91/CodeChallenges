package com.example.codechallenges.strings.easy

/**
Generate Document

You're given a string of available characters and a string representing a
document that you need to generate. Write a function that determines if you
can generate the document using the available characters. If you can generate
the document, your function should return true; otherwise, it
should return false.


You're only able to generate the document if the frequency of unique
characters in the characters string is greater than or equal to the frequency
of unique characters in the document string. For example, if you're given
characters = "abcabc" and document = "aabbccc" you
cannot generate the document because you're missing one c.


The document that you need to create may contain any characters, including
special characters, capital letters, numbers, and spaces.

Note: you can always generate the empty string ("").
Sample Input
characters = "Bste!hetsi ogEAxpelrt x "
document = "AlgoExpert is the Best!"

Sample Output
true

 **/

fun generateDocument(characters: String, document: String): Boolean {
    // Write your code here.
    val charSplit: MutableList<String> = characters.split("") as MutableList
    val validCharacters = mutableListOf<Char>()
    for (char in document) {
        if (char.toString() in charSplit) {
            charSplit.remove(char.toString())
            validCharacters.add(char)
        }
    }
    return validCharacters.size == document.length
}

fun main() {
    println(generateDocument("aheaolabbhb", "hello"))
}

// O(m * (n + m)) time | O(1) space - where n is the number
// of characters and m is the length of the document
fun sampleOneGenerateDocument(characters: String, document: String): Boolean {
    for (character in document) {
        val documentFrequency = countCharacterFrequency(character, document)
        val characterFrequency = countCharacterFrequency(character, characters)
        if (documentFrequency > characterFrequency) return false
    }

    return true
}

fun countCharacterFrequency(character: Char, target: String): Int {
    var frequency = 0
    for (char in target) {
        if (char == character) frequency += 1
    }
    return frequency
}

// O(c * (n + m)) time | O(c) space - where n is the number of characters, m is
// the length of the document, and c is the number of unique characters in the document
fun sampleTwoGenerateDocument(characters: String, document: String): Boolean {
    val alreadyCounted = mutableSetOf<Char>()

    for (character in document) {
        if (character in alreadyCounted) continue

        val documentFrequency = countCharacterFrequency(character, document)
        val characterFrequency = countCharacterFrequency(character, characters)
        if (documentFrequency > characterFrequency) return false

        alreadyCounted.add(character)
    }

    return true
}

// O(n + m) time | O(c) space - where n is the number of characters, m is
// the length of the document, and c is the number of unique characters in the characters string
fun sampleThreeGenerateDocument(characters: String, document: String): Boolean {
    val characterCounts = mutableMapOf<Char, Int>()

    for (character in characters) {
        if (character !in characterCounts) characterCounts[character] = 0

        characterCounts[character] = characterCounts[character] !! + 1
    }

    for (character in document) {
        if (character !in characterCounts || characterCounts[character] == 0) return false

        characterCounts[character] = characterCounts[character]!! - 1
    }

    return true
}