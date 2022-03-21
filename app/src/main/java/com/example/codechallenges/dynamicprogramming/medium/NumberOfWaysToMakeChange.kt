package com.example.codechallenges.dynamicprogramming.medium


/* Given an array of distinct positive integers representing coin denominations and a
single non-negative integer <span>n</span> representing a target amount of
money, write a function that returns the number of ways to make change for
that target amount using the given coin denominations.

Note that an unlimited amount of coins is at your disposal.

Sample Input
n = 6
denoms = [1, 5]

Sample Output
2 - 1x1 + 1x5 and 6x1
*/


fun sampleNumberOfWaysToMakeChange(n: Int, denoms: List<Int>): Int {
    val ways = MutableList(n + 1) { 0 }
    ways[0] = 1
    for (denom in denoms) {
        for (amount in 1 until n + 1) {
            if (denom <= amount) {
                ways[amount] += ways[amount - denom]
            }
        }
    }
    return ways[n]
}

