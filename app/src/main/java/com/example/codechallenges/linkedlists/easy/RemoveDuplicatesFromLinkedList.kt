package com.example.codechallenges.linkedlists.easy

import com.example.codechallenges.datastructures.Node

/**
Remove Duplicates From Linked List

You're given the head of a Singly Linked List whose nodes are in sorted order
with respect to their values. Write a function that returns a modified version
of the Linked List that doesn't contain any nodes with duplicate values. The
Linked List should be modified in place (i.e., you shouldn't create a brand
new list), and the modified Linked List should still have its nodes sorted
with respect to their values.

Each LinkedList node has an integer value as well as
a next node pointing to the next node in the list or to
None / null if it's the tail of the list.

Sample Input
linkedList = 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6 - the head node with value 1

Sample Output
1 -> 3 -> 4 -> 5 -> 6 - the head node with value 1
 **/

// O(n) time | O(1) space - where n is the number of nodes in the LinkedList
fun removeDuplicatesFromLinkedList(linkedList: Node): Node {
    // Write your code here.
    var node: Node? = linkedList

    while (node != null) {
        var nextNode = node.next
        while (nextNode != null && nextNode.value == node.value) {
            nextNode = nextNode.next
        }

        node.next = nextNode
        node = nextNode
    }
    return linkedList
}

fun main() {
    val head = Node(1)
    val node2 = Node(1)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(4)
    val node6 = Node(4)
    val node7 = Node(5)
    val node8 = Node(6)
    val tail = Node(6)
    head.next = node2
    node2.next = node3
    node4.next = node4
    node5.next = node6
    node6.next = node7
    node7.next = node8
    node8.next = tail

    println(removeDuplicatesFromLinkedList(head))

}