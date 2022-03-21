package com.example.codechallenges.tries.medium

/*
Write a function that takes in a big string and an array of small strings,
all of which are smaller in length than the big string. The function should
return an array of booleans, where each boolean represents whether the small
string at that index in the array of small strings is contained in the big
string.

Sample Input 1
bigString = "this is a big string"
smallString = ["this", "yo", "is", "a", "bigger", "string", "kappa"]
Sample Output 1
[true, false, true, true, false, true, false]

Sample Input 2
bigString = "abcdefghijklmnopqrstuvwxyz"
smallStrings = ["abc", "mnopqr", "wyz", "no", "e", "tuuv"]
Sample Output 2
[true, true, false, true, true, false]
*/

fun trieMultiStringSearch(bigString: String, smallStrings: List<String>): List<Boolean> {
    val trie = Trie()
    for (string in smallStrings) {
        trie.insert(string)
    }
    val containedStrings = mutableMapOf<String, Boolean>()
    for (i in bigString.indices) {
        findSmallStringsIn(bigString, i, trie, containedStrings)
    }
    return smallStrings.map { string -> containedStrings.containsKey(string)}
}

private fun findSmallStringsIn(string: String, startIdx: Int, trie: Trie, containedStrings: MutableMap<String, Boolean>) {
    var currentNode = trie.root
    for (i in startIdx until string.length) {
        val currentChar = string[i]
        if (!currentNode.children.containsKey(currentChar)) break
        currentNode = currentNode.children[currentChar]!!
        if (currentNode.children.containsKey(trie.endSymbol)) containedStrings[currentNode.word] = true
    }
}

private data class TrieNode(
    val children: MutableMap<Char, TrieNode?> = mutableMapOf(),
    var word: String = ""
)
private class Trie {
    val root = TrieNode()
    val endSymbol = '*'

    fun insert(string: String) {
        var current = root
        for (i in string.indices) {
            if (!current.children.containsKey(string[i])) {
                current.children[string[i]] = TrieNode()
            }
            current = current.children[string[i]]!!
        }
        current.children[endSymbol] = null
        current.word = string
    }
}