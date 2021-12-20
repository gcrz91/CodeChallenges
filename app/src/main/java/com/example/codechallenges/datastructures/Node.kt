package com.example.codechallenges.datastructures

open class Node(value: Int) {
    var value = value
    var next: Node? = null
    override fun toString(): String {
        return "Node(value=$value, next=$next)"
    }
}
