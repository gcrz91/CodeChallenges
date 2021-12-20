package com.example.codechallenges.arrays

fun arrayOfProducts(array: List<Int>): List<Int> {
    // Write your code here.
    val productArray = mutableListOf<Int>()
    for (i in array.indices) {
        var sum = 1
        for (j in array.indices) {
            if (i != j) {
                sum *= array[j]
            }
        }
        productArray.add(sum)
    }
    return productArray
}

fun main() {
    println(arrayOfProducts(listOf(5, 1, 4, 2)))
}