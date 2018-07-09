package com.ung8023.a3rdframework.dagger2.qualifier

class RAMStorage {

    val name: String
    val size: Int

    init {
        println("init方法")
    }

    constructor(name: String, size: Int) {
        this.name = name
        this.size = size
        println("构造方法")
    }

    fun printMsg() {
        println("厂家: $name, 内存大小$size")
    }
}