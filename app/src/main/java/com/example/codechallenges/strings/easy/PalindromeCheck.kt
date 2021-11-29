package com.example.codechallenges.strings.easy

/**
Palindrome Check

Write a function that takes in a non-empty string and that returns a boolean
representing whether the string is a palindrome.

A palindrome is defined as a string that's written the same forward and
backward. Note that single-character strings are palindromes.

Sample Input
string = "abcdcba"

Sample Output
true - It's written the same forward and backward
 **/

fun isPalindrome(string: String): Boolean {
    // Write your code here.
    val strBuilder = StringBuilder()
    for (i in string.length - 1 downTo 0) {
        strBuilder.append(string[i])
    }
    return strBuilder.toString() == string
}

fun main() {
    println(isPalindrome("abcdcba"))
}

// O(n^2) time | O(n) space
fun sampleOneIsPalindrome(string: String): Boolean {
    var reversedString = ""
    for (i in string.length - 1 downTo 0) {
        reversedString += string[i]
    }
    return string == reversedString
}

// O(n) time | O(n) space
fun sampleTwoIsPalindrome(string: String): Boolean {
    val reversedChars = mutableListOf<Char>()
    for (i in string.length - 1 downTo 0) {
        reversedChars.add(string[i])
    }
    return string == reversedChars.joinToString("")
}

// O(n) time | O(n) space
fun sampleThreeIsPalindrome(string: String, i: Int = 0): Boolean {
    val j = string.length - 1 - i
    return if (i >= j) true else string[i] == string[j] && sampleThreeIsPalindrome(string, i + 1)
}

// O(n) time | O(1) space
fun sampleFourIsPalindrome(string: String): Boolean {
    var leftIdx = 0
    var rightIdx = string.length - 1
    while (leftIdx < rightIdx) {
        if (string[leftIdx] != string[rightIdx]) return false
        leftIdx++
        rightIdx--
    }
    return true
}