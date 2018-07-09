package com.ung8023.a3rdframework.dagger2.scope

import dagger.Module
import dagger.Provides

@Module
class PenModule {
    @PenScope @Provides fun providePen(): Pen{
        return Pen("好笔")
    }
}