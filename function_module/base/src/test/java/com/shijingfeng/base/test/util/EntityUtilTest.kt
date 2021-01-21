package com.shijingfeng.base.test.util

import org.junit.Test

/**
 * Function:
 * Date: 2021/1/21 15:30
 * Description:
 * Author: ShiJingFeng
 */
class EntityUtilTest {

    @Test
    fun getPositionById() {
        val position = com.shijingfeng.base.util.getPositionById("", listOf())

        assert(position != -1)
    }
}