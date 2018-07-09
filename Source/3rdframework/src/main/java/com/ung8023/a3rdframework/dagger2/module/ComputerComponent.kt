package com.ung8023.a3rdframework.dagger2.module

import com.ung8023.a3rdframework.dagger2.qualifier.RAMStorageFactory
import dagger.Component

@Component(modules = [MainBoardFactory::class, RAMStorageFactory::class])
interface ComputerComponent {
    fun inject(computer: Computer)
}