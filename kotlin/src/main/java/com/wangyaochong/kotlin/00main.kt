package com.wangyaochong.kotlin

import com.wangyaochong.java.UtilPrint
import com.wangyaochong.kotlin.func.printStar2

fun main(args: Array<String>) {
    println("abc");
    UtilPrint.print("use java")
    printStar(5)
    printStar2(5)
    val str = "123"
    println(str)
    val strMultiple = """
        |这是一个
        |多行文本""".trimMargin()
    println(strMultiple)

}