package com.example.codechallenges.easy

import kotlin.math.abs

/**
Sorted Squared Array

Write a function that takes in a non-empty array of integers that are sorted
in ascending order and returns a new array of the same length with the squares
of the original integers also sorted in ascending order.

Sample Input
array = [1, 2, 3, 5, 6, 8, 9]

Sample Output
[1, 4, 9 25, 36, 64, 81]
 **/

fun sortedSquaredArray(array: List<Int>): List<Int> {
    // Write your code here.
    return array.map { it * it }.sortedBy { it }
}

fun main() {
    println(sortedSquaredArray(listOf(1, 2, 3, 5, 6, 8, 9)))
}

// O(nlogn) time | O(n) space - where n is the length of the input array
fun sampleOneSortedSquaredArray(array: List<Int>): List<Int> {
    val sortedSquares = array.map() { _ -> 0 }.toMutableList()

    for (idx in array.indices) {
        val value = array[idx]
        sortedSquares[idx] = value * value
    }
    sortedSquares.sort()
    return sortedSquares
}

// O(n) time | O(n) space - where n is the length of the input array
fun sampleTwoSortedSquaredArray(array: List<Int>): List<Int> {
    val sortedSquares = array.map() { _ -> 0 }.toMutableList()
    var smallerValueIdx = 0
    var largerValueIdx = array.size - 1

    for (idx in array.size - 1 downTo 0) {
        val smallerValue = array[smallerValueIdx]
        val largerValue = array[largerValueIdx]

        if (abs(smallerValue) > abs(largerValueIdx)) {
            sortedSquares[idx] = smallerValue * smallerValue
            smallerValueIdx += 1
        } else {
            sortedSquares[idx] = largerValue * largerValue
            largerValueIdx -= 1
        }
    }
    return sortedSquares
}
