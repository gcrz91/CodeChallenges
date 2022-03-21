package com.example.codechallenges.recursion.medium

/*
Write a function that takes in an array of unique integers and returns
an array of all permutations of those integers in no particular order.

If the input array is empty, the function should return an empty array.

Sample Input
array = [1, 2, 3]

Sample Output
[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
*/

fun main() {
//    println(recursiveGetPermutations(listOf(1, 2, 3)))
    println(getPermutations(listOf(1,2,3)))
}

fun recursiveGetPermutations(array: List<Int>): List<List<Int>> {
    val permutations = mutableListOf<List<Int>>()
    recursiveGetPermutations(0, array.toMutableList(), permutations)
    return permutations
}

fun recursiveGetPermutations(
    i: Int,
    array: MutableList<Int>,
    permutations: MutableList<List<Int>>
) {
    if (i == array.size - 1) {
        permutations.add(array.toList())
        return
    }
    for (j in i until array.size) {
        swap(array, i, j)
        recursiveGetPermutations(i + 1, array, permutations)
        swap(array, i, j)
    }
}

fun swap(array: MutableList<Int>, i: Int, j: Int) {
    val tmp = array[i]
    array[i] = array[j]
    array[j] = tmp
}


// Solution 2

fun getPermutations(array: List<Int>): List<List<Int>> {
    val permutations = mutableListOf<List<Int>>()
    getPermutations(array, listOf<Int>(), permutations)
    return permutations
}

fun getPermutations(
    array: List<Int>,
    currentPermutation: List<Int>,
    permutations: MutableList<List<Int>>
) {
    println("array = $array")
    if (array.isEmpty() && currentPermutation.isNotEmpty()) {
        permutations.add(currentPermutation)
        return
    }

    for (el in array) {
        val newArray = array.toMutableList()
        newArray.remove(el)
        val newPermutation = currentPermutation.toMutableList()
        newPermutation.add(el)
        println("newPermutation = $newPermutation")
        getPermutations(newArray, newPermutation, permutations)
    }
}