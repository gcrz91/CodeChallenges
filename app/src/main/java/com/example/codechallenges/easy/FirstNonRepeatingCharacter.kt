package com.example.codechallenges.easy

import android.annotation.SuppressLint

/**
First Non-Repeating Character

Write a function that takes in a string of lowercase English-alphabet letters
and returns the index of the string's first non-repeating character.

The first non-repeating character is the first character in a string that
occurs only once.

If the input string doesn't have any non-repeating characters, your function
should return

Sample Input = "abcdcaf"

Sample Output
1 // the first non-repeating character is "b" and is found at index 1
 **/
fun firstNonRepeatingCharacter(string: String): Int {
    // Write your code here.
    if (string.length == 1) return 0
    println(string)
    val duplicates = mutableSetOf<Char>()
    outerLoop@ for (i in 0 until string.length - 1) {
        val charOne = string.get(i)
        for (j in i + 1 until string.length) {
            val charTwo = string.get(j)
            if (charOne == charTwo) {
                duplicates.add(charOne)
                continue@outerLoop
            }
            if (j == string.length - 1 && !duplicates.contains(charOne)) {
                return i
            } else if (i == string.length - 2 && !duplicates.contains(charTwo)) {
                return j
            }
        }
    }
    return -1
}

fun main() {
    println(firstNonRepeatingCharacter("abcdcaf"))
}

fun sampleOneFirstNonRepeatingCharacter(string: String): Int {
    for (idx in string.indices) {
        var foundDuplicate = false
        for (idx2 in string.indices) {
            if (string[idx] == string[idx2] && idx != idx2) {
                foundDuplicate = true
            }

            if (!foundDuplicate) return idx
        }
    }

    return -1
}

@SuppressLint("NewApi")
fun sampleTwoFirstNonRepeatingCharacter(string: String): Int {
    val characterFrequencies = mutableMapOf<Char, Int>()

    for (character in string) {
        characterFrequencies[character] = characterFrequencies.getOrDefault(character, 0) + 1
    }

    for (idx in string.indices) {
        val character = string[idx]
        if (characterFrequencies[character] == 1) return idx
    }

    return -1
}