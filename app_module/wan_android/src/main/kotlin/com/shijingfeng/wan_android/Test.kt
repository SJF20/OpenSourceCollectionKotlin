package com.shijingfeng.wan_android

import android.os.Parcel
import android.os.Parcelable
import com.shijingfeng.base.util.e

/**
 * Function:
 * Date: 2020/11/23 15:18
 * Description:
 * @author ShiJingFeng
 */
class Test() : Parcelable {

    constructor(parcel: Parcel) : this()

    override fun writeToParcel(parcel: Parcel, flags: Int) {}

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Test> {
        override fun createFromParcel(parcel: Parcel): Test = Test(parcel)

        override fun newArray(size: Int): Array<Test?> = arrayOfNulls(size)
    }

//    @JvmField
//    var varTest = "varTest"
//
//    object A {
//
//        @JvmField
//        val varA1: String = "varA1"
//        var varA2: Int = 110
//
//        fun funA1() {
//            e("测试", "函数 funA1")
//        }
//    }
//
//    companion object B {
//
//        @JvmField
//        var varB1 = ""
//
//        @JvmStatic
//        fun funB1() {
//            e("测试", "函数 funB1")
//        }
//    }

}