package com.wangyaochong.kotlin.classHiarchey

/**
 *@author wangyaochong
 *@date 2020/4/23 08:51
 */
class FuncClass {
    companion object {
        @JvmStatic
        @JvmOverloads
        fun add(x: Int, y: Int = 1): Int = x + y
    }
}