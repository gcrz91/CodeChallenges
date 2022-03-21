package com.example.codechallenges.datastructures

data class TrieNode(
    val children: MutableMap<Char, TrieNode> = mutableMapOf()
)
