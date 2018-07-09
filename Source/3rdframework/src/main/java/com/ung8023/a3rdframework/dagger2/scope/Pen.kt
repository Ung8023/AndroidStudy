package com.ung8023.a3rdframework.dagger2.scope

class Pen {
    val name: String

    constructor(name: String) {
        this.name= name
        println("Pen构造方法")
    }
}