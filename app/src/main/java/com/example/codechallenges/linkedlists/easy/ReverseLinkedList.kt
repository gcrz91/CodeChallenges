package com.example.codechallenges.linkedlists

import com.example.codechallenges.datastructures.Node


fun reverseLinkedList(head: Node): Node {
    var previousNode: Node? = null
    var currentNode: Node? = head
    while (currentNode != null) {
        val nextNode = currentNode.next
        println("previous $previousNode")
        println("current $currentNode")
        println("next $nextNode \n\n")
        currentNode.next = previousNode
        previousNode = currentNode
        currentNode = nextNode
    }
    return previousNode!!
}

fun main() {
    val n1 = Node(1)
    val n2 = Node(2)
    val n3 = Node(3)
    val n4 = Node(4)
    val n5 = Node(5)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5

    println(reverseLinkedList(n1))
}