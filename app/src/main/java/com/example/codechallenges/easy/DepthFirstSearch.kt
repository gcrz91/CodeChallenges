package com.example.codechallenges.easy

/**
 Depth-first Search
 <p>
 You're given a <span>Node</span> class that has a <span>name</span> and an
 array of optional <span>children</span> nodes. When put together, nodes form
 an acyclic tree-like structure.
 </p>

 <p>
 Implement the <span>depthFirstSearch</span> method on the
 <span>Node</span> class, which takes in an empty array, traverses the tree
 using the Depth-first Search approach (specifically navigating the tree from
 left to right), stores all of the nodes' names in the input array, and returns
 it.
 </p>
 <p>
 If you're unfamiliar with Depth-first Search, we recommend watching the
 Conceptual Overview section of this question's video explanation before
 starting to code.
 </p>
 Sample Output
 graph =          A
               /  |  \
              B   C  D
             / \   / \
            E   F  G   H
               / \  \
              I   J  K

 Sample Output
 ["A", "B", "E", "F", "I", "J", "C", "D", "K", "H"]
 **/

class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()

    fun depthFirstSearch(): List<String> {
        // Write your code here.
        val childrenNames = mutableListOf<String>(name)
        children.forEach {
            childrenNames.addAll(it.depthFirstSearch())
        }
        return childrenNames
    }
}

class SampleNode(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()

    fun depthFirstSearch(): List<String> {
        return depthFirstSearch()
    }

    fun depthFirstSearch(array: MutableList<String>): List<String> {
        array.add(this.name)
        for (child in this.children) {
            child.depthFirstSearch()
        }
        return array
    }
}