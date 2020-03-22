package com.shijingfeng.base.base.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.viewmodel.BaseViewModel
import com.shijingfeng.library.util.CastUtil
import java.lang.reflect.InvocationTargetException

/** 简单工厂模式创建实例 */
fun createCommonViewModelFactory(
    constructorParamArray: Array<out Any>? = null,
    repository: BaseRepository<*, *>? = null
) = CommonViewModelFactory(constructorParamArray, repository)

/**
 * Function: 通用 ViewModel 工厂
 * Date: 2020/1/22 19:36
 * Description:
 * @author ShiJingFeng
 */
class CommonViewModelFactory internal constructor(
    private var mConstructorParamArray: Array<out Any>? = null,
    private var mRepository: BaseRepository<*, *>? = null
) : ViewModelProvider.Factory {

    /**
     * 创建 ViewModel
     * @param modelClass 要创建的 ViewModel 反射类
     */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var viewModel: ViewModel? = null

        try {
            val constructorParamArray: Array<out Any>? = mConstructorParamArray

            if (constructorParamArray != null) {
                val clzArray: Array<Class<*>?> = arrayOfNulls(constructorParamArray.size)

                for (i in constructorParamArray.indices) {
                    val any = constructorParamArray[i]

                    clzArray[i] = any.javaClass
                }
                viewModel = modelClass.getConstructor(*clzArray).newInstance(*constructorParamArray)
            } else {
                viewModel = modelClass.newInstance()

                if (mRepository != null) {
                    //反射设置值
                    val field = BaseViewModel::class.java.getDeclaredField("mRepository")

                    field.isAccessible = true
                    field.set(viewModel, mRepository)
                }
            }
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }

        return CastUtil.cast(viewModel)
    }

}