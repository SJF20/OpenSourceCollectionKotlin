package com.shijingfeng.base.mvvm.livedata

import android.annotation.SuppressLint
import androidx.annotation.AnyThread
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.ThreadUtils
import com.shijingfeng.base.util.v
import com.shijingfeng.base.util.w
import java.util.concurrent.atomic.AtomicBoolean

private const val TAG = "SingleLiveEvent"

/**
 * Function: A lifecycle-aware observable that sends only new updates after subscription, used for events like navigation and Snackbar messages (防止循环更新).
 * Date: 2020/1/29 9:29
 * Description:
 * @author ShiJingFeng
 */
class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val mPending = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        if (hasActiveObservers()) {
            w(TAG, "Multiple observers registered but only one will be notified of changes.")
        }
        super.observe(owner, Observer {t: T ->
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    /**
     * 有参数调用
     *
     * @param value 参数
     */
    @SuppressLint("WrongThread")
    @AnyThread
    override fun setValue(value: T?) {
        mPending.set(true)
        if (ThreadUtils.isMainThread()) {
            super.setValue(value)
        } else {
            postValue(value)
        }
    }

    /**
     * 无参数调用
     */
    @AnyThread
    fun call() {
        mPending.set(true)
        if (ThreadUtils.isMainThread()) {
            value = null
        } else {
            postValue(null)
        }
    }

}