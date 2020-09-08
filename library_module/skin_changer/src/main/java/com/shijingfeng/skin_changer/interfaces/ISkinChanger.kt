package com.shijingfeng.skin_changer.interfaces

import android.view.View
import com.shijingfeng.skin_changer.entity.SkinAttribute

/**
 * Function:
 * Date: 2020/9/8 13:26
 * Description:
 * @author ShiJingFeng
 */
interface ISkinChanger {

    /**
     * 获取资源
     */
    fun getResource(): Map<View, List<SkinAttribute>>?

}