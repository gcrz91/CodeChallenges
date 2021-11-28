package com.example.codechallenges.sortingalgorithms

/**
Bubble Sort

Write a function that takes in an array of integers and returns
a sorted version of that array. Use the Bubble Sort algorithm to
sort the array.

Bubble sort, sometimes referred to as sinking sort is a simple
sorting algorithm that repeatedly steps through the list, compares
adjacent elements and swaps them if they are in the wrong order.
The pass through the list is repeated until the list is sorted.

Sample Input
array = [8, 5, 2, 9, 5, 6, 3]

Sample Output
[2, 3, 5, 5, 6, 8, 9]
 **/

fun bubbleSort(array: MutableList<Int>): List<Int> {
    // Write your code here.
    if (array.isEmpty()) return array
    var isSorted = false

    while (!isSorted) {
        var timesSorted = 0
        for (i in 0 until array.size - 1) {
            val current = array[i]
            val next = array[i + 1]
            if (current > next) {
                array[i] = next
                array[i + 1] = current
                timesSorted += 1
            }
        }
        isSorted = timesSorted == 0
    }

    return array
}


fun main() {
    println(bubbleSort(mutableListOf(8, 5, 2, 9, 5, 6, 3)))
}

// Best: O(n) time | O(1) time
// Average: O(n^2) time | O(1) space
// Worst: O(n^2) time | O(1) space
fun sampleOneBubbleSort(array: MutableList<Int>): List<Int> {
    if (array.size == 0) return array
    var isSorted = false
    var counter = 0
    while (!isSorted) {
        isSorted = true
        for (i in 0 until array.size - 1 - counter) {
            if (array[i] > array[i + 1]) {
                swap(i, i + 1, array)
                isSorted = false
            }
        }
        counter++
    }

    return array
}

fun swap(i: Int, j: Int, array: MutableList<Int>) {
    val temp = array[j]
    array[j] = array[i]
    array[i] = temp
}