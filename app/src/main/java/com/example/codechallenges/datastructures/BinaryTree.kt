package com.example.codechallenges.datastructures

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

open class Level(val root: BinaryTree?, val depth: Int)