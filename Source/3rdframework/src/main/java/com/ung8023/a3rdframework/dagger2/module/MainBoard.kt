package com.ung8023.a3rdframework.dagger2.module


class MainBoard {

    private val factoryName: String

    constructor(factoryName: String ) {
        this.factoryName = factoryName
    }

    fun run() {
        println("主板运行起来了!")
    }
}