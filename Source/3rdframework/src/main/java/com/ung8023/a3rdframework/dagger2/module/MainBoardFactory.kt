package com.ung8023.a3rdframework.dagger2.module

import dagger.Module
import dagger.Provides

@Module
class MainBoardFactory {

    @Provides fun provideHuaShuoMainBoard(): MainBoard {
        return MainBoard("华硕")
    }

}