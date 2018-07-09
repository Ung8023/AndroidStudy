package com.ung8023.a3rdframework.dagger2.base

import dagger.Component

@Component
interface CarComponent {
    fun inject(car: Car)
}