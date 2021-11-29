package com.example.codechallenges.binarysearchtrees.veryhard

/**
Right Smaller Than

Write a function that takes in an array of integers and returns an array of
the same length, where each element in the output array corresponds to the
number of integers in the input array that are to the right of the relevant
index and that are strictly smaller than the integer at that index.

In other words, the value at output[i] represents the number of
integers that are to the right of i and that are strictly smaller
than input[i].

Sample Input
array = [8, 5, 11, -1, 3, 4, 2]

Sample Output
[5, 4, 4, 0, 1, 1, 0]
// There are 5 integers smaller than 8 to the right of it.
// There are 4 integers smaller than 5 to the right of it.
// There are 4 integers smaller than 11 to the right of it.
// Etc..

 **/

// Solution One
// Use BST
fun solutionOneRightSmallerThan(array: List<Int>): List<Int> {
    // Write your code here.
    if (array.isEmpty()) return emptyList()
    val lessThanList = mutableListOf<Int>()
    for (i in array.indices) {
        var lessThan = 0
        for (j in i + 1 until array.size) {
            if (array[i] > array[j]) {
                lessThan += 1
            }
        }
        lessThanList.add(lessThan)
    }

    return lessThanList
}

fun main() {
    println(solutionOneRightSmallerThan(listOf(8, 5, 11, -1, 3, 4, 2)))
}