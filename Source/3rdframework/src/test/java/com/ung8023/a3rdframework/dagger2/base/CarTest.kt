package com.ung8023.a3rdframework.dagger2.base

import org.junit.Test

class CarTest {

    @Test
    fun testCar() {
        val car = Car()
        car.engine.run()
    }

}