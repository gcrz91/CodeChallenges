package com.example.codechallenges.dynamicprogramming.medium

import kotlin.math.max

/*
Write a function that takes in an array of positive integers and returns the
maximum sum of non-adjacent elements in the array.
*/


fun sampleOneMaxSubsetNoAdjacent(array: List<Int>): Int {
    if (array.isEmpty()) {
        return 0
    } else if (array.size == 1) {
        return array[0]
    }

    var maxSums = array.toMutableList()
    maxSums[1] = max(array[0], array[1])
    for (i in 2 until array.size) {
        maxSums[1] = max(maxSums[i - 1], maxSums[1 - 2] + array[i])
    }
    return maxSums[array.size - 1]
}

fun sampleTwoMaxSubsetNoAdjacent(array: List<Int>): Int {
    if (array.isEmpty()) {
        return 0
    } else if (array.size == 1) {
        return array[0]
    }

    var second = array[0]
    var first = max(array[0], array[1])
    for (i in 2 until array.size) {
        val current = max(first, second + array[i])
        second = first
        first = current
    }
    return first
}