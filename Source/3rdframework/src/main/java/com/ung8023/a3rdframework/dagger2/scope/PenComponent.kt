package com.ung8023.a3rdframework.dagger2.scope

import dagger.Component

@PenScope
@Component(modules = [PenModule::class])
interface PenComponent {
    fun inject(pen: PenBag)
}