package com.wangyaochong.kotlin

/**
 *@author wangyaochong
 *@date 2020/4/23 05:32
 */

fun main(args: Array<String>) {
    var list = listOf("123", "12345", "3")
    list = list.sortedBy { it.length }
    for (s in list) {
        println(s)
    }
    list.forEach { e -> print(e) }
    repeat(9) {

    }
}