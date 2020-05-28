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

    val list1 = listOf("123", "456")
    val list2 = listOf("abc", "efg")
    println()
    println(list1 + list2)

    println("合并列表${list1 merge list2 merge list}")

    val listInt1 = listOf(1, 3, 4)
    val listInt2 = listOf(4, 5, 6)
    println("列表乘法${listInt1 * listInt2}")

}

//使用operator fun
private operator fun List<Int>.times(listInt2: List<Int>): Int {
    var sum = 0
    for (number in this) {
        for (inner in listInt2) {
            sum += number * inner
        }
    }
    return sum
}

//使用infix fun
private infix fun <E> List<E>.merge(list2: List<E>): List<E> {
    return this.plus(list2)
}
