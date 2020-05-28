package com.wangyaochong.kotlin

/**
 *@author wangyaochong
 *@date 2020/4/23 05:34
 */

fun main(args: Array<String>) {
    val map = mapOf("abc" to 1, "efg" to 2)
    for (entry in map) {
        println("${entry.key},${entry.value}")
    }

    val map2 = HashMap<String, Int>();
    map2["abc"] = 1;
    map2["456"] = 2;
    map2.forEach { entry -> println("${entry.key},${entry.value}") };
    map2.forEach { (key) -> println("key=$key") };


    val map3 = mapOf(Pair("a", 1), Pair("b", 2))
    print(map3)

}