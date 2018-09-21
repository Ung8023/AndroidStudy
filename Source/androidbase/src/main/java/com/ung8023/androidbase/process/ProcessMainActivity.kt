package com.ung8023.androidbase.process

import cn.ung8023.androidstudy.activity.ActivityEntity
import cn.ung8023.androidstudy.activity.BaseMainActivity
import com.ung8023.androidbase.process.aidlbook.BookManagerActivity
import com.ung8023.androidbase.process.binderpool.BinderPoolActivity
import com.ung8023.androidbase.process.messager.MessengerActivity

class ProcessMainActivity : BaseMainActivity() {
    override fun getData(): MutableList<ActivityEntity> {
        return mutableListOf(ActivityEntity("process", ProcessAActivity::class.java),
                ActivityEntity("Messenger", MessengerActivity::class.java),
                ActivityEntity("AIDL Book", BookManagerActivity::class.java),
                ActivityEntity("AIDL BinderPool", BinderPoolActivity::class.java)
                )
    }
}