package com.shijingfeng.base.thread_executor

import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicInteger

/** 默认线程数量 (CPU核心数量(四核四线程就是8个核心) + 1) */
private val DEFAULT_THREAD_COUNT = Runtime.getRuntime().availableProcessors() + 1
/** 默认最大线程数量 */
private val DEFAULT_MAX_THREAD_COUNT = DEFAULT_THREAD_COUNT
/** 默认存活时间 30单位时间(具体单位需要看构造方法中传入的单位是什么) */
private const val DEFAULT_KEEP_ALIVE_TIME = 30L

/** 单例实例 */
@Volatile
private var sInstance: CustomThreadExecutor? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getCustomThreadExecutorInstance(): CustomThreadExecutor {
    if (sInstance == null) {
        synchronized(CustomThreadExecutor::class.java) {
            if (sInstance == null) {
                sInstance = CustomThreadExecutor()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 自定义线程池
 * Date: 2020/12/7 11:29
 * Description:
 * Author: ShiJingFeng
 */
class CustomThreadExecutor @JvmOverloads constructor(
    corePoolSize: Int = DEFAULT_THREAD_COUNT,
    maximumPoolSize: Int = DEFAULT_MAX_THREAD_COUNT,
    keepAliveTime: Long = DEFAULT_KEEP_ALIVE_TIME,
    unit: TimeUnit = TimeUnit.SECONDS,
    workQueue: BlockingQueue<Runnable> = ArrayBlockingQueue(64),
    threadFactory: ThreadFactory = CustomThreadFactory(),
    handler: RejectedExecutionHandler = RejectedExecutionHandler { runable, executor -> }
): ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler)

/** 线程池编号 */
private val sThreadPoolNumber = AtomicInteger(0)
/** 同一线程池内线程编号 */
private val sThreadNumber = AtomicInteger(0)

/**
 * 自定义线程工厂
 */
class CustomThreadFactory(

    /** 是否设置为守护线程 (当线程只剩下守护线程的时候, JVM就会退出, 用于自动关闭线程) true: 设置为守护线程 */
    isDaemon: Boolean = false,

    /** 线程优先级 */
    priority: Int = Thread.NORM_PRIORITY,

    /** 线程内 异常捕捉器 */
    uncaughtExceptionHandler: Thread.UncaughtExceptionHandler = Thread.UncaughtExceptionHandler { _, _ -> }

) : ThreadFactory {

    private val mIsDaemon = isDaemon
    private val mPriority = priority
    private val mUncaughtExceptionHandler = uncaughtExceptionHandler

    /** 所属线程组 */
    private val mThreadGroup by lazy {
        val securityManager = System.getSecurityManager()

        if (securityManager != null) {
            securityManager.threadGroup
        } else {
            // Android设备执行此分支
            Thread.currentThread().threadGroup
        }
    }

    override fun newThread(runable: Runnable?): Thread {
        val threadPoolDesc = "线程池编号: ${sThreadPoolNumber.getAndIncrement()}"
        val threadDesc = "线程编号: ${sThreadNumber.getAndIncrement()}"

        return Thread(mThreadGroup, runable, "$threadPoolDesc  $threadDesc", 0).apply {
            isDaemon = mIsDaemon
            priority = mPriority
            uncaughtExceptionHandler = mUncaughtExceptionHandler
        }
    }
}