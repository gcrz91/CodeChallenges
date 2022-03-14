package com.example.codechallenges.recursion.easy

//The Fibonacci sequence is defined as follows: the first number of the sequence
//is 0, the second number is 1, and the nth number is the sum of the (n - 1)th
//and (n - 2)th numbers. Write a function that takes in an integer
//n and returns the nth Fibonacci number.
//
//Important note: the Fibonacci sequence is often defined with its first two
//numbers as F0 = 0 and F1 = 1. For the purpose of
//this question, the first Fibonacci number is F0; therefore,
//getNthFib(1) is equal to F0, getNthFib(2)
//is equal to F1, etc..

fun main() {
    println(getNthFib(5))
    println(getNthFib(10))
    println(getNthFib(15))

    println(getNthFibRecursive(5))
    println(getNthFibRecursive(10))
    println(getNthFibRecursive(15))
}

fun getNthFib(n: Int): Int {
    var lastTwo = Pair(0, 1)
    var counter = 3
    while (counter <= n) {
        val nextFib = lastTwo.first + lastTwo.second
        lastTwo = Pair(lastTwo.second, nextFib)
        counter++
    }
    return if (n > 1) lastTwo.second else lastTwo.first
}

fun getNthFibRecursive(n: Int): Int {
    if (n == 2) {
        return 1
    } else if (n == 1) {
        return 0
    }

    return getNthFibRecursive(n - 1) + getNthFibRecursive(n - 2)
}