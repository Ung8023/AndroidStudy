package com.ung8023.a3rdframework.dagger2.module

import com.ung8023.a3rdframework.dagger2.qualifier.QualifierA
import com.ung8023.a3rdframework.dagger2.qualifier.QualifierB
import com.ung8023.a3rdframework.dagger2.qualifier.RAMStorage
import com.ung8023.a3rdframework.dagger2.qualifier.RAMStorageFactory
import javax.inject.Inject

/**
 Computer需要一个主板时，并且这个主板，构造方法需要入参时，或者主板我们不能操作时，通过Module来获取
 */
class Computer {

    @Inject
    lateinit var mainBoard: MainBoard

    @field:QualifierA("4G内存") @Inject lateinit var storageA: RAMStorage

    @field:QualifierA("8G内存") @Inject lateinit var storageB: RAMStorage

    constructor() {
        DaggerComputerComponent.builder().
                rAMStorageFactory(RAMStorageFactory()).
                mainBoardFactory(MainBoardFactory()).build().inject(this)
    }

}