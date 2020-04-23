package com.wangyaochong.kotlin

/**
 *@author wangyaochong
 *@date 2020/4/23 04:32
 */

fun printStar(count: Int) {
    for (i in 1..count) {
        print("*")
    }
    println()
}

fun add(x: Int, y: Int = 1): Int {
    return x + y
}

fun sub(x: Int, y: Int): Int = x - y

fun defaultParamFun(x: Int = 2) {
    println("param=$x")
}

fun highFun(x: List<Int>, func1: (p: Int) -> Int, func2: (p: Int) -> Int = { it }): List<Int> {//高阶函数
    return x.map(func1).map(func2)
}

fun main(args: Array<String>) {
    printStar(2)
    println(add(1, 2))
    println(sub(1, 2))
    val div: (Double, Double) -> Double = { x, y -> x / y }
    println(div(2.0, 3.0))
    val mul = { x: Int, y: Int -> x * y }
    println(mul(2, 3))


    defaultParamFun(1)
    defaultParamFun(x = 3)
    defaultParamFun()

    println(highFun(listOf(1, 2, 3), { a -> a * 2 }))
    println(highFun(listOf(1, 2, 3), { a -> a * 2 }, { a -> a + 1 }));
}
