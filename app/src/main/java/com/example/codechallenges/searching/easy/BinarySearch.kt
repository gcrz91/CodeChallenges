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

fun binarySearch(array: List<Int>, target: Int): Int {
    // Write your code here.
    return -1
}

fun main() {
    println(binarySearch(listOf(0, 1, 21, 33, 45, 45, 61, 71, 72, 73), 33))
}

fun sampleOneBinarySearch(array: List<Int>, target: Int): Int {
    return -1
}