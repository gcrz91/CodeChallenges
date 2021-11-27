package com.example.codechallenges.easy

/**
Validate Subsequence

Given two non-empty arrays of integers, write a function that determines
whether the second array is a subsequence of the first one.

A subsequence of an array is a set of numbers that aren't necessarily adjacent
in the array but that are in the same order as they appear in the array. For
instance, the numbers [1, 3, 4] form a subsequence of the array
[1, 2, 3, 4], and so do the numbers [2, 4]. Note that a single number
in an array and the array itself are both valid subsequences of the array.

Sample Input
array = [5, 1, 22, 25, 6, -1, 8, 10]
sequence = [1, 6, -1, 10]

Sample Output
true
 **/

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    // Write your code here.
    var sequenceIndx = 0
    for (value in array) {
        if (sequenceIndx == sequence.size) break
        if (sequence[sequenceIndx] == value) sequenceIndx++
    }

    return sequenceIndx == sequence.size
}

fun main() {
    println(isValidSubsequence(listOf(5, 1, 22, 25, 6, -1, 8, 10), listOf(1, 6, -1, 10)))
}

// O(n) time | O(1) space - where n is the length of the array
fun sampleOneIsValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    var arrIdx = 0
    var seqIdx = 0
    while (arrIdx < array.size && seqIdx < sequence.size) {
        if (array[arrIdx] == sequence[seqIdx]) seqIdx++
        arrIdx++
    }
    return seqIdx == sequence.size
}

// O(n) time | O(1) space - where n is the length of the array
fun sampleTwoIsValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    var seqIdx = 0
    for (value in array) {
        if (seqIdx == sequence.size) break
        if (sequence[seqIdx] == value) seqIdx++
    }
    return seqIdx == sequence.size
}