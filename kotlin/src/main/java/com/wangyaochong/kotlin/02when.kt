package com.wangyaochong.kotlin

/**
 *@author wangyaochong
 *@date 2020/4/23 05:05
 */

fun main(args: Array<String>) {
    println(checkNumber(2))
}

fun checkNumber(number: Int): String {
    return when (number) {
        1 -> "1"
        2 -> "two"
        3 -> "三"
        else -> "其他数字"
    }
}