package com.ung8023.a3rdframework.dagger2

import cn.ung8023.androidstudy.activity.ActivityEntity
import cn.ung8023.androidstudy.activity.BaseMainActivity

class Dagger2MainActivity :BaseMainActivity() {
    override fun getData(): MutableList<ActivityEntity> = ArrayList<ActivityEntity>().apply {

    }
}