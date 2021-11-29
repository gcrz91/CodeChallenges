package com.example.codechallenges.searching.easy

/**
 Find Three Largest Numbers

 Write a function that takes in an array of at least three integers and,
 without sorting the input array, returns a second array of the three
 largest integers in the input array.

 The function should return duplicates if necessary; for example it
 should return [10, 10, 12] for an array of [10, 5, 9, 10, 12]

 Sample Input
 array = [141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7]

 Sample Output
 [18, 141, 541]
 **/

fun findThreeLargestNumbers(array: List<Int>): List<Int> {
    // Write your code here.
    val largestNumbers = mutableListOf<Int>(Int.MIN_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)
    for (num in array) {
        if (largestNumbers[2] < num) {
            shiftAndUpdate(largestNumbers, num, 2)
            continue
        } else if (largestNumbers[1] < num) {
            shiftAndUpdate(largestNumbers, num, 1)
            continue
        } else if (largestNumbers[0] < num) {
            shiftAndUpdate(largestNumbers, num, 0)
            continue
        }
    }
    return largestNumbers
}

fun shiftAndUpdate(array: MutableList<Int>, num: Int, idx: Int) {
    for (i in 0..idx) {
        if (i == idx) {
            array[i] = num
        } else {
            array[i] = array[i + 1]
        }
    }
}

fun main() {
    println(findThreeLargestNumbers(listOf(141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7)))
}