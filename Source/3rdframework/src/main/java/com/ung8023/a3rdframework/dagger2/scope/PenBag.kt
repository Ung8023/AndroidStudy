package com.ung8023.a3rdframework.dagger2.scope

import javax.inject.Inject

class PenBag {

    @Inject lateinit var pen1 : Pen
    @Inject lateinit var pen2 : Pen

    constructor() {
        DaggerPenComponent.builder().penModule(PenModule()).build().inject(this)
    }
}