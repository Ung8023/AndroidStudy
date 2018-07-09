package com.ung8023.a3rdframework.dagger2.module

import org.junit.Test

class ComputerTest {

    @Test
    fun test() {
        val da = Computer()
        da.mainBoard.run()
        da.storageA.printMsg()
        da.storageB.printMsg()
    }
}