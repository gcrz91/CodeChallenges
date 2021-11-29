package com.example.codechallenges.binarysearchtrees.easy

/**
Find Closest Value in BinaryTree

Write a function that takes in a Binary Search Tree (BinaryTree) and a target integer
value and returns the closest value to that target value contained in the BinaryTree.

You can assume that there will only be one closest value.

Each BinaryTree node has an integer value, a
left child node, and a right child node. A node is
said to be a valid BinaryTree node if and only if it satisfies the BinaryTree
property: its value is strictly greater than the values of every
node to its left; its value is less than or equal to the values
of every node to its right; and its children nodes are either valid
BinaryTree nodes themselves or None / null.

Sample Input
tree =      10
/     \
5      15
/  \    /  \
2    5 13   22
/         \
1          14
target = 12

Sample Output
13
 **/

import com.example.codechallenges.datastructures.BinaryTree
import kotlin.math.abs

fun findClosestValueInBst(tree: BinaryTree, target: Int): Int {
    // Write your code here.
    var minDifference = abs(tree.value - target)
    var closestValue = tree.value
    val values = mutableListOf<Int>()

    traverseTree(tree, values)
    values.forEach {
        val difference = abs(target - it)
        if (difference < minDifference) {
            minDifference = difference
            closestValue = it
        }
    }
    return closestValue
}

fun traverseTree(tree: BinaryTree, listOfValues: MutableList<Int>): List<Int> {
    if (tree.left != null) {
        listOfValues.add(tree.left!!.value)
        traverseTree(tree.left!!, listOfValues)
    }
    if (tree.right != null) {
        listOfValues.add(tree.right!!.value)
        traverseTree(tree.right!!, listOfValues)
    }
    return listOfValues
}


fun main() {
    val bst1 = BinaryTree(10)
    val bst2 = BinaryTree(5)
    val bst3 = BinaryTree(15)
    val bst4 = BinaryTree(2)
    val bst5 = BinaryTree(5)
    val bst6 = BinaryTree(13)
    val bst7 = BinaryTree(22)
    val bst8 = BinaryTree(1)
    val bst9 = BinaryTree(14)
    bst1.apply {
        left = bst2
        right = bst3
    }
    bst2.apply {
        left = bst4
        right = bst5
    }
    bst4.left = bst8
    bst3.apply {
        left = bst6
        right = bst7
    }
    bst6.left = bst9

    println(findClosestValueInBst(bst1, 12))
}

// Average: O(log(n)) time | O(log(n)) space
// Worst: O(n) time | O(n) space
fun sampleOneFindClosestValueInBst(tree: BinaryTree, target: Int): Int {
    return sampleOneFindClosestValueInBstHelper(tree, target, tree.value)
}

fun sampleOneFindClosestValueInBstHelper(tree: BinaryTree, target: Int, closest: Int): Int {
    var newClosest = closest

    if (abs(target - closest) > abs(target - tree.value)) {
        newClosest = tree.value
    }
    return if (target < tree.value && tree.left != null) {
        sampleOneFindClosestValueInBstHelper(tree.left!!, target, newClosest)
    } else if (target > tree.value && tree.right != null) {
        sampleOneFindClosestValueInBstHelper(tree.right!!, target, newClosest)
    } else {
        newClosest
    }
}