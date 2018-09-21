package com.ung8023.androidbase.process.binderpool

class ComputeImpl : ICompute.Stub() {
    override fun add(a: Int, b: Int): Int {
        return a + b
    }
}