package com.example.codechallenges.binarytrees.easy

import com.example.codechallenges.datastructures.BinaryTree

/**
Branch Sums

Write a function that takes in a Binary Tree and returns a list of its branch
sums ordered from leftmost branch sum to rightmost branch sum.

A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree
branch is a path of nodes in a tree that starts at the root node and ends at
any leaf node.

Each BinaryTree node has an integer value, a
left child node, and a right child node. Children
nodes can either be BinaryTree nodes themselves or
None / null.

Sample Input
tree =             1
/    \
2       3
/   \    / \
4      5  6   7
/ \    /
8  9  10

Sample Output
[15, 16, 18, 10, 11]
// 15 == 1 + 2 + 4 + 8
// 16 == 1 + 2 + 4 + 9
// 18 == 1 + 2 + 5 + 10
// 10 == 1 + 3 + 6
// 11 == 1 + 3 + 7

 **/

fun branchSums(root: BinaryTree): List<Int> {
    // Write your code here.
    return sumOfBranches(root, 0, mutableListOf<Int>())
}

fun sumOfBranches(tree: BinaryTree, currentSum: Int, sumList: MutableList<Int>): MutableList<Int> {
    val newSum = currentSum + tree.value
    if (tree.left != null) {
        sumOfBranches(tree.left!!, newSum, sumList)
    }
    if (tree.right != null) {
        sumOfBranches(tree.right!!, newSum, sumList)
    }
    if (tree.left == null && tree.right == null) {
        sumList.add(newSum)
    }
    return sumList
}

fun main() {
    val root = BinaryTree(1)
    val bst2 = BinaryTree(2)
    val bst3 = BinaryTree(3)
    val bst4 = BinaryTree(4)
    val bst5 = BinaryTree(5)
    val bst6 = BinaryTree(6)
    val bst7 = BinaryTree(7)
    val bst8 = BinaryTree(8)
    val bst9 = BinaryTree(9)
    val bst10 = BinaryTree(10)
    root.apply {
        left = bst2
        right = bst3
    }
    bst2.apply {
        left = bst4
        right = bst5
    }
    bst3.apply {
        left = bst6
        right = bst7
    }
    bst4.apply {
        left = bst8
        right = bst9
    }
    bst5.left = bst10
    println(branchSums(root))
}

// O(n) time | O(n) space - where n is the number of nodes in the Binary Tree
fun sampleBranchSums(root: BinaryTree): List<Int> {
    val sums = mutableListOf<Int>()
    calculateBranchSums(root, 0, sums)
    return sums
}

fun calculateBranchSums(node: BinaryTree?, runningSum: Int, sums: MutableList<Int>) {
    if (node == null) return

    val newRunningSum = runningSum + node.value
    if (node.left == null && node.right == null) {
        sums.add(newRunningSum)
        return
    }

    calculateBranchSums(node.left, newRunningSum, sums)
    calculateBranchSums(node.right, newRunningSum, sums)
}