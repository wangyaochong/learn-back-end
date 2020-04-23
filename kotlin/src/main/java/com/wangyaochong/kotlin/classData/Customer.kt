package com.wangyaochong.kotlin.classData

import lombok.Data

/**
 *@author wangyaochong
 *@date 2020/4/23 11:22
 */
@Data
data class Customer(var name: String, var email: String) {

}

class Man(var name: String, var age: Int) {
    operator fun component1() = name
    operator fun component2() = age
}

fun main(args: Array<String>) {
    var (name, email) = Customer("abc", "xxx@xxx")
    var customer = Customer("efg", "sdfsd@")
    println("$name,$email")
    println("$customer")

    var (name2, age2) = Man("lisi", 12)
    println(Man("lisi", 12))

}