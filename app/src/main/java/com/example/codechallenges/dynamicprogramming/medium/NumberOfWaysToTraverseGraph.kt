package com.example.codechallenges.dynamicprogramming.medium


/*
You're given two positive integers representing the width and height of a
grid-shaped, rectangular graph. Write a function that returns the number of
ways to reach the bottom right corner of the graph when starting at the top
left corner. Each move you take must either go down or right. In other words,
you can never move up or left in the graph.

For example, given the graph illustrated below, with
width = 2 and height = 3, there are three ways to
reach the bottom right corner when starting at the top left corner:

 _ _
|_|_|
|_|_|
|_|_|

1. Down, Down, Right
2. Right, Down, Down,
3. Down , Right, Down
*/

fun main() {
//    println(recursiveNumberOfWaysToTraverseGraph(3, 4))
//    println(iterativeNumberOfWaysToTraverseGraph(3,4))
    println(factorialNumberOfWaysToTraverseGraph(3,4))
    println(factorialNumberOfWaysToTraverseGraph(7,10))
}

fun recursiveNumberOfWaysToTraverseGraph(width: Int, height: Int): Int {
    println("height = $height, width = $width")
    if (width == 1 || height == 1) return 1

    return recursiveNumberOfWaysToTraverseGraph(
        width - 1,
        height
    ) + recursiveNumberOfWaysToTraverseGraph(
        width,
        height - 1
    )
}

fun iterativeNumberOfWaysToTraverseGraph(width: Int, height: Int): Int {
    val numberOfWays = MutableList(height + 1) { MutableList(width + 1) { 0 } }

    for (widthIdx in 1 until width + 1) {
        for (heightIdx in 1 until height + 1) {
            if (widthIdx == 1 || heightIdx == 1) {
                numberOfWays[heightIdx][widthIdx] = 1
            } else {
                val waysLeft = numberOfWays[heightIdx][widthIdx - 1]
                val waysUp = numberOfWays[heightIdx - 1][widthIdx]
                numberOfWays[heightIdx][widthIdx] = waysLeft + waysUp
            }
            println("graph = $numberOfWays")
        }
    }

    return numberOfWays[height][width]
}

fun factorialNumberOfWaysToTraverseGraph(width: Int, height: Int): Int {
    val xDistanceToCover = width - 1
    val yDistanceToCover = height - 1

    // The number of permutations of right and down movements
    // is the number of ways to reach the bottom right corner.
    val numerator = factorial(xDistanceToCover + yDistanceToCover)
    println("numerator = $numerator")
    val denominator = factorial(xDistanceToCover) * factorial(yDistanceToCover)
    println("denominator = $denominator")
    return numerator/denominator
}

fun factorial(num: Int): Int {
    var result = 1

    for (n in 2 until num + 1) {
        result *= n
    }

    return result
}