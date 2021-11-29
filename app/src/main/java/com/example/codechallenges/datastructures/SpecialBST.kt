package com.example.codechallenges.datastructures

open class SpecialBST(value: Int, idx: Int, numSmallerAtInsertTime: Int) {
    var value = value
    var idx = idx
    var numSmallerAtInsertTime = numSmallerAtInsertTime
    var leftSubtreeSize = 0
    var left: SpecialBST? = null
    var right: SpecialBST? = null

    fun insert(value: Int, idx: Int, numSmallerAtInsertTime: Int = 0) {
        if (value < this.value) {
            this.leftSubtreeSize++
            if (this.left == null) {
                this.left = SpecialBST(value, idx, numSmallerAtInsertTime)
            } else {
                this.left!!.insert(value, idx, numSmallerAtInsertTime)
            }
        } else {
            var newNumSmallerAtInsertTime = numSmallerAtInsertTime + this.leftSubtreeSize
            if (value > this.value) newNumSmallerAtInsertTime++
            if (this.right == null) {
                this.right = SpecialBST(value, idx, newNumSmallerAtInsertTime)
            } else {
                this.right!!.insert(value, idx, newNumSmallerAtInsertTime)
            }
        }
    }
}