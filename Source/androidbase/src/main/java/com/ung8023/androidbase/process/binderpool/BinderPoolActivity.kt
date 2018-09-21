package com.ung8023.androidbase.process.binderpool

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.ung8023.androidbase.R

class BinderPoolActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binder_pool)
    }

    fun doWork(view: View) {
//        val binderPool = BinderPool.getInstance(this)
//        binderPool?.queryBinder(BinderPool.BINDER_COMPUTE)

        Thread(Runnable { doIt() }).start()
    }

    fun doIt() {
        val binderPool = BinderPool.getInstance(this)
        val securityBinder =
                binderPool?.queryBinder(BinderPool.BINDER_SECURITY_CENTER)
        val mSecurityCenter = ISecurityCenter.Stub.asInterface(securityBinder)
        val msg = "helloworld - android"
        Log.w("content:", msg)
        val encrypt = mSecurityCenter.encrypt(msg)
        Log.w("encrypt:", encrypt)
        val decrypt = mSecurityCenter.decrypt(encrypt)
        Log.w("decrypt:", decrypt)

        val computeBinder = binderPool?.queryBinder(BinderPool.BINDER_COMPUTE)
        val mCompute = ICompute.Stub.asInterface(computeBinder)
        Log.w("3+5 = ", "" + mCompute.add(3, 5))
    }
}
