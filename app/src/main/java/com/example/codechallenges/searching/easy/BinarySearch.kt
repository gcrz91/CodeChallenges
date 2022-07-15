package com.example.codechallenges.searching.easy

/**
Binary Search

Write a function that takes in a sorted array of integers as well as a target
integer. The function should use the Binary Search algorithm to determine if
the target integer is contained in the array and should return its index if it
is, otherwise -1.

In computer science, binary search, also known as half-interval search,
logarithmic search, or binary chop, is a search algorithm that finds
the position of a target value within a sorted array. Binary search
compares the target value to the middle element of the array.

Worst complexity: O(log n)
Average complexity: O(log n)
Best complexity: O(1)
Space complexity: O(1)
Data structure: Array
Class: Search algorithm

Sample Input
array = [0, 1, 21, 33, 45, 45, 61, 71, 72, 73]
target = 33

Sample Output
3
 **/

private fun binarySearch(array: List<Int>, target: Int): Int {
    // Write your code here.
    return binarySearchHelper(array, target)
}

private fun binarySearchHelper(array: List<Int>, target: Int): Int {
    var left: Int = 0
    var right: Int = array.lastIndex
    var middle: Int = (left + right) / 2

    while (left <= right) {
        val currentValue = array[middle]
        if (target < currentValue) {
            right = middle - 1
        } else if (target > currentValue) {
            left = middle + 1
        } else {
            return middle
        }
        middle = (left + right) / 2
    }
    return -1
}

private fun main() {
    println(binarySearch(listOf(0, 1, 21, 33, 45, 45, 61, 71, 72, 73), 33))
}

// O(log(n)) time | O(log(n)) space
private fun sampleOneBinarySearch(array: List<Int>, target: Int): Int {
    return sampleOneBinarySearchHelper(array, target, 0, array.lastIndex)
}

private fun sampleOneBinarySearchHelper(
    array: List<Int>,
    target: Int,
    left: Int,
    right: Int
): Int {
    if (left > right) {
        return -1
    }
    val middle = (left + right) / 2
    val current = array[middle]
    return if (target == current) {
        middle
    } else if (target < current) {
        sampleOneBinarySearchHelper(array, target, left, middle - 1)
    } else {
        sampleOneBinarySearchHelper(array, target, left + 1, right)
    }
}

private fun sampleTwoBinarySearch(array: List<Int>, target: Int): Int {
    var left = 0
    var right = array.lastIndex
    while (left <= right) {
        val middle = (left + right) / 2
        val current = array[middle]
        if (target == current) {
            return middle
        } else if (target < current) {
            right = middle - 1
        } else {
            left = middle - 1
        }
    }
    return -1
}
