package com.shijingfeng.base.thread_executor

import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicInteger

/** 默认线程数量 (CPU核心数量(四核四线程就是8个核心) + 1) */
private val DEFAULT_THREAD_COUNT = Runtime.getRuntime().availableProcessors() + 1
/** 默认最大线程数量 */
private val DEFAULT_MAX_THREAD_COUNT = DEFAULT_THREAD_COUNT
/** 默认存活时间 30单位时间(具体单位需要看构造方法中传入的单位是什么) */
private const val DEFAULT_KEEP_ALIVE_TIME = 30L

/** 单线程线程池实例 对象锁 */
private val sSingleThreadExecutorObjectLock = Any()
/** 单线程线程池 (用于在一个后台线程中同步执行) */
@Volatile
private var sSingleThreadExecutorInstance: CustomThreadExecutor? = null

/** CPU密集型线程池实例 对象锁 */
private val sCPUThreadExecutorObjectLock = Any()
/** CPU密集型线程池 */
@Volatile
private var sCPUThreadExecutorInstance: CustomThreadExecutor? = null

/**
 * DCL双检 获取 单线程线程池 实例
 *
 * @return 单线程线程池 实例
 */
internal fun getSingleThreadExecutorInstance(): CustomThreadExecutor {
    if (sSingleThreadExecutorInstance == null) {
        synchronized(sSingleThreadExecutorObjectLock) {
            if (sSingleThreadExecutorInstance == null) {
                sSingleThreadExecutorInstance = CustomThreadExecutor(
                    corePoolSize = 1,
                    maximumPoolSize = 1,
                    keepAliveTime = 0L,
                    unit = TimeUnit.MILLISECONDS,
                    workQueue = LinkedBlockingQueue()
                )
            }
        }
    }
    return sSingleThreadExecutorInstance!!
}

/**
 * DCL双检 获取 CPU密集型线程池 实例
 *
 * @return 实例
 */
internal fun getCPUThreadExecutorInstance(): CustomThreadExecutor {
    if (sCPUThreadExecutorInstance == null) {
        synchronized(sCPUThreadExecutorObjectLock) {
            if (sCPUThreadExecutorInstance == null) {
                sCPUThreadExecutorInstance = CustomThreadExecutor()
            }
        }
    }
    return sCPUThreadExecutorInstance!!
}

/**
 * Function: 自定义线程池
 * Date: 2020/12/7 11:29
 * Description:
 * Author: ShiJingFeng
 */
class CustomThreadExecutor @JvmOverloads constructor(
    // 核心线程数量 (不会被销毁)
    corePoolSize: Int = DEFAULT_THREAD_COUNT,
    // 最大线程数量
    maximumPoolSize: Int = DEFAULT_MAX_THREAD_COUNT,
    // 非核心线程(最大线程数量 - 核心线程数量)空闲时多久被销毁
    keepAliveTime: Long = DEFAULT_KEEP_ALIVE_TIME,
    // 销毁时间单位
    unit: TimeUnit = TimeUnit.SECONDS,
    // 管理线程的队列
    workQueue: BlockingQueue<Runnable> = ArrayBlockingQueue(64),
    // 线程工厂 (用于创建线程和设置线程参数)
    threadFactory: ThreadFactory = CustomThreadFactory(),
    // 线程策略 (如果线程池满了, 超过了最大线程数量, 新加入的线程应该被执行何等策略), 可以自定义策略(RejectedExecutionHandler), 默认策略有以下几种
    // AbortPolicy: 该策略是线程池的默认策略。使用该策略时，如果线程池队列满了丢掉这个任务并且抛出RejectedExecutionException异常。
    // DiscardPolicy: 这个策略和AbortPolicy的slient版本，如果线程池队列满了，会直接丢掉这个任务并且不会有任何异常。
    // DiscardOldestPolicy: 丢弃最老的。也就是说如果队列满了，会将最早进入队列的任务删掉腾出空间，再尝试加入队列。因为队列是队尾进，队头出，所以队头元素是最老的，因此每次都是移除对头元素后再尝试入队。
    // CallerRunsPolicy: 如果添加到线程池失败，那么主线程会自己去执行该任务，不会等待线程池中的线程去执行。就像是个急脾气的人，我等不到别人来做这件事就干脆自己干。
    handler: RejectedExecutionHandler = RejectedExecutionHandler { runable, executor -> }
): ThreadPoolExecutor(
    corePoolSize,
    maximumPoolSize,
    keepAliveTime,
    unit,
    workQueue,
    threadFactory,
    handler
)

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