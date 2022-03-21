package com.example.codechallenges.tries.medium

import com.example.codechallenges.datastructures.TrieNode

/*
Write a SuffixTrie class for a Suffix-Trie-like data structure. The class should
have a root property set to be the root node of teh trie and should support:
    - Creating the trie from a string; this will be done by calling the populateSuffixTrieFrom
      method upon class instantiation, which should populate the root of the class.
    - Searching for the strings in the trie.

    Note that every string added to the trie should end with a special endSymbol character "*"

    Sample Input = "babc"

    Sample Output =
    {
        "c" : {"*": true},
        "b" : {
            "c": {"*": true},
            "a": {"b": {"c": {"*": true}}}
        },
        "a": {"b": {"c": {"*": true}}}
    }
 */

class SuffixTree(str: String) {
    val endSymbol = '*'
    var root = TrieNode()

    init {
        populate(str)
    }

    fun populate(str: String) {
        for (i in str.indices) {
            insertSubstringStartingAt(i, str)
        }
    }

    fun contains(str: String): Boolean {
        var node = root
        for (letter in str) {
            val child = node.children[letter] ?: return false
            node = child
        }
        return node.children.containsKey(endSymbol)
    }

    fun insertSubstringStartingAt(i: Int, str: String) {
        var node = root
        for (j in i until str.length) {
            val letter = str[j]
            val child = node.children[letter]
            if (child == null) {
                val newNode = TrieNode()
                node.children[letter] = newNode
            }
            node = node.children[letter]!!
        }
        node.children[endSymbol] = TrieNode()
    }
}