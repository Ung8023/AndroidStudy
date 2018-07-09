package com.ung8023.a3rdframework

import cn.ung8023.androidstudy.activity.ActivityEntity
import cn.ung8023.androidstudy.activity.BaseMainActivity
import com.ung8023.a3rdframework.amazon.AmazonMainActivity
import com.ung8023.a3rdframework.dagger2.Dagger2MainActivity

class MainActivity : BaseMainActivity() {
    override fun getData(): MutableList<ActivityEntity> {
        return ArrayList<ActivityEntity>().apply {
            add(ActivityEntity("Amazon Cognito", AmazonMainActivity::class.java))
            add(ActivityEntity("Dagger2", Dagger2MainActivity::class.java))
        }
    }
}