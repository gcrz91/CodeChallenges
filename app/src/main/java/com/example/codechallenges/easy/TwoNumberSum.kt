package com.example.codechallenges.easy

//Two Number Sum

//Write a function that takes in a non-empty array of distinct integers and an
//integer representing a target sum. If any two numbers in the input array sum
//up to the target sum, the function should return them in an array, in any
//order. If no two numbers sum up to the target sum, the function should return
//an empty array.

// Sample Input
// array = [3, 5, -4, 8, 11, 1, -1, 6]
// targetSum = 10

// Sample Output
// [-1, 11] the numbers could be in reverse order

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    // Write your code here.
    val integers = mutableSetOf<Int>()
    for (i in 0 until array.size - 1) {
        for (j in i+1 until array.size) {
            if (array[i] + array[j] == targetSum) {
                integers.add(array[i])
                integers.add(array[j])
            }
        }
    }
    return integers.toList()
}

fun main() {
    println(twoNumberSum(mutableListOf(3, 5, -4, 8, 11, 1, -1, 6), 10))
}