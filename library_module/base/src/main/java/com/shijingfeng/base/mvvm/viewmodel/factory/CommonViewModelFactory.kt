package com.shijingfeng.base.mvvm.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.util.showDebugLongToast
import kotlin.Exception

/** 简单工厂模式创建实例 */
fun createCommonViewModelFactory(
    repository: BaseRepository<*, *>? = null
) = CommonViewModelFactory(repository)

/**
 * Function: 通用 ViewModel 工厂
 * Date: 2020/1/22 19:36
 * Description:
 * Author: ShiJingFeng
 */
class CommonViewModelFactory internal constructor(
    private var mRepository: BaseRepository<*, *>? = null
) : ViewModelProvider.Factory {

    /**
     * 创建 ViewModel
     * @param modelClass 要创建的 ViewModel 反射类
     */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return try {
            if (mRepository != null) {
                val constructor = modelClass.getConstructor(mRepository!!::class.java)

                constructor.newInstance(mRepository)
            } else {
                modelClass.newInstance()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            showDebugLongToast("ViewModel工厂创建ViewModel失败: " + modelClass.name)
            throw Exception("ViewModel工厂创建ViewModel失败: " + modelClass.name)
        }
    }

    /**
     * 创建 ViewModel
     * @param modelClass 要创建的 ViewModel 反射类
     */
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        var viewModel: ViewModel? = null
//
//        val constructorParamArray = mConstructorParamArray
//
//        if (constructorParamArray != null) {
//            val clzArray: Array<Class<*>?> = arrayOfNulls(constructorParamArray.size)
//
//            for (i in constructorParamArray.indices) {
//                val any = constructorParamArray[i]
//
//                clzArray[i] = any.javaClass
//            }
//            try {
//                viewModel = modelClass.getConstructor(*clzArray).newInstance(*constructorParamArray)
//            } catch (e: Exception) {
//                e.printStackTrace()
//                showDebugLongToast("CommonViewModelFactory错误: 指定构造方法参数错误(构造方法参数类型不一致 或 数量不一致)")
//            }
//        } else {
//            try {
//                viewModel = modelClass.newInstance()
//            } catch (e: Exception) {
//                e.printStackTrace()
//                showDebugLongToast("CommonViewModelFactory错误: 创建无参构造方法失败(没有无参构造方法)")
//            }
//
//            if (mRepository != null) {
//                try {
//                    //反射设置值
//                    val field = BaseViewModel::class.java.getDeclaredField("mRepository")
//
//                    field.isAccessible = true
//                    field.set(viewModel, mRepository)
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                    showDebugLongToast("CommonViewModelFactory错误: 反射设置 mRepository 错误 (检查ViewModel基类中是否有 mRepository 是否类型一致)")
//                }
//            }
//        }
//
//        return cast(viewModel)
//    }

}