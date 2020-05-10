package com.shijingfeng.wan_android.entity

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 搜索热词 实体类
 * Date: 20-5-3 下午10:07
 * Description:
 * @author shijingfeng
 */
internal data class SearchHotWordEntity(

    @SerializedName("id")
    var identity: String,

    @SerializedName("link")
    var link: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("order")
    var order: Int,

    @SerializedName("visible")
    var visible: Int

) : BaseEntity() {

    /**
     * 获取ID
     * @return ID
     */
    override fun getId(): String {
        return identity
    }

}