package com.ung8023.androidbase.process.binderpool

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.os.RemoteException
import com.ung8023.androidbase.process.binderpool.BinderPool.Companion.BINDER_COMPUTE
import com.ung8023.androidbase.process.binderpool.BinderPool.Companion.BINDER_SECURITY_CENTER
import java.util.concurrent.CountDownLatch

class BinderPool {

    private var mContext: Context? = null
    private var mBinderPool: IBinderPool? = null
    private var mConnectBinderPoolCountDownLatch: CountDownLatch? = null

    private var mBinderPoolDeathRecipient = IBinder.DeathRecipient {
        unLink()
    }

    private fun unLink() {
        mBinderPool?.asBinder()?.unlinkToDeath(mBinderPoolDeathRecipient, 0)
        mBinderPool = null
        connectBinderPoolService()
    }

    private var mBinderPoolConnection = object : ServiceConnection{
        override fun onServiceDisconnected(name: ComponentName?) {
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            mBinderPool = IBinderPool.Stub.asInterface(service)
            try {
                mBinderPool?.asBinder()?.linkToDeath(mBinderPoolDeathRecipient, 0)
            }catch (e: RemoteException) {
                e.printStackTrace()
            }
            mConnectBinderPoolCountDownLatch?.countDown()
        }

    }

    fun queryBinder(binderCode: Int) : IBinder? {
        try {
            return mBinderPool?.queryBinder(binderCode)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return null
    }

    private constructor(context: Context) {
        mContext = context.applicationContext
        connectBinderPoolService()
    }

    private fun connectBinderPoolService() {
        mConnectBinderPoolCountDownLatch = CountDownLatch(1);
        val intent = Intent(mContext, BinderPoolService::class.java)
        mContext?.bindService(intent, mBinderPoolConnection, Context.BIND_AUTO_CREATE)
        try {
            mConnectBinderPoolCountDownLatch?.await()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    companion object {
        const val TAG = "BinderPool"
        const val BINDER_NONE = -1
        const val BINDER_COMPUTE = 0
        const val BINDER_SECURITY_CENTER = 1
        private var sInstance : BinderPool? = null

        fun getInstance(context: Context): BinderPool? {
            if (sInstance == null) {
                synchronized(BinderPool::class.java) {
                    if (sInstance == null) {
                        sInstance = BinderPool(context)
                    }
                }
            }
            return sInstance
        }
    }

}


class BinderPoolImpl : IBinderPool.Stub() {
    override fun queryBinder(binderCode: Int): IBinder? {
        return when(binderCode) {
            BINDER_COMPUTE -> ComputeImpl()
            BINDER_SECURITY_CENTER -> SecurityCenterImpl()
            else -> null
        }
    }
}