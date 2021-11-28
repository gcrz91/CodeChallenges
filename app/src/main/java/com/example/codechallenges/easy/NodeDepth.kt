package com.example.codechallenges.easy

import com.example.codechallenges.datastructures.BinaryTree

/**
Node Depths

The distance between a node in a Binary Tree and the tree's root is called the
node's depth.

Write a function that takes in a Binary Tree and returns the sum of its nodes'
depths.

Each BinaryTree node has an integer value, a
left child node, and a right child node. Children
nodes can either be BinaryTree nodes themselves or
None / null.

 Sample Input
 tree =             1
                  /   \
                 2     3
                / \   / \
               4   5 6   7
              / \
             8   9

Sample output
16
// The depth of the node with value 2 is 1.
// The depth of the node with value 3 is 1.
// The depth of the node with value 4 is 2.
// The depth of the node with value 5 is 2.
// Etc..
// Summing all of these depths yields 16.

 **/

fun nodeDepths(root: BinaryTree): Int {
    // Write your code here.
    val depthValues = mutableListOf<Int>()
    calculateDepthSum(root, 0, depthValues)
    return depthValues.sum()
}

fun calculateDepthSum(node: BinaryTree, depth: Int, depthValues: MutableList<Int>) {
    depthValues.add(depth)
    if (node.right != null) {
        calculateDepthSum(node.right!!, depth + 1, depthValues)
    }
    if (node.left != null) {
        calculateDepthSum(node.left!!, depth + 1, depthValues)
    }
    return
}