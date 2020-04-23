package com.wangyaochong.kotlin

/**
 *@author wangyaochong
 *@date 2020/4/23 05:54
 */

fun main(args: Array<String>) {
    try {
        1 / 0;
    } catch (e: Exception) {
        e.printStackTrace()
    }
}