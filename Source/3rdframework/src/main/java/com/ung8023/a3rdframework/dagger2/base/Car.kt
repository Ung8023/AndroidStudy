package com.ung8023.a3rdframework.dagger2.base

import javax.inject.Inject

/**
 当一个Car需要一个engine的时候，并且engine可直接通过构造方法提供时
 */
class Car {
    @Inject lateinit var engine: Engine

    constructor() {
        DaggerCarComponent.builder().build().inject(this)
    }
}