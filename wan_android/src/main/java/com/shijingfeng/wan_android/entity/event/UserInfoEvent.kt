package com.shijingfeng.wan_android.entity.event

import com.shijingfeng.wan_android.entity.network.UserInfoEntity

/**
 * Function: 用户信息 数据更新 Event
 * Date: 2020/2/3 19:58
 * Description:
 * @author ShiJingFeng
 */
internal data class UserInfoEvent(

    /** 用户信息数据实体类 */
    var newUserInfoEntity: UserInfoEntity

)