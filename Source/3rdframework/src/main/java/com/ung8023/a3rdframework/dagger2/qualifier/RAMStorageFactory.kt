package com.ung8023.a3rdframework.dagger2.qualifier

import dagger.Module
import dagger.Provides

@Module
class RAMStorageFactory {

    @Provides @QualifierA("4G内存") fun provide4GStorage() :RAMStorage {
        return RAMStorage("JinShidun", 4)
    }

    @Provides @QualifierA("8G内存")  fun provide8GStorage() :RAMStorage {
        return RAMStorage("JinShidun", 8)
    }
}