package com.ung8023.a3rdframework.dagger2.base

import javax.inject.Inject

class Engine {

    @Inject
    constructor()

    fun run() {
        println("Running")
    }
}