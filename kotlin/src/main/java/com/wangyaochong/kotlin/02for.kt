package com.wangyaochong.kotlin

import com.wangyaochong.java.UtilProvider

/**
 *@author wangyaochong
 *@date 2020/4/23 04:35
 */

fun main(args: Array<String>) {
//    1..10 = [1,10]
//    1 until 10 [1,10)

    for (index in 1..10) {
        print(index)
    }
    println()
    for (index in 1 until 10) {
        print(index)
    }
    println()
    for (index in 1..10 step 2) {
        print(index)
    }
    println()
    for (index in 10 downTo 1) {
        print(index)
    }
    println()
    for (value in UtilProvider.provideIntegerList()) {
        print(value)
    }
    println()

    for (value in UtilProvider.provideIntegerList().withIndex()) {
        print(value)
    }
    println()
    val provideIntegerArray = UtilProvider.provideIntegerArray()
    for ((value, index) in provideIntegerArray.withIndex()) {
        print("$value,$index")
    }
    println()
    for (index in provideIntegerArray.indices) {
        print("$index")
    }
    println()
    for ((value, index) in arrayOf("a", "b", "c").withIndex()) {
        print("index=$index,value=$value")
    }
    println()
    for (index in arrayOf("a", "b", "c").indices) {
        print("index=$index")
    }
    println()
    repeat(10) { print(it) }
    println()
    val string = String("abc".toCharArray())
    println(string)
}


