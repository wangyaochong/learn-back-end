package com.wangyaochong.kotlin

/**
 *@author wangyaochong
 *@date 2020/4/23 05:00
 */

fun main(args: Array<String>) {
    var str1 = "abc"
    var str2 = "abc"
    var str3 = "Abc"
    print(str1 == str2)
    print(str1 === str2)
    print(str1.equals(str3, true))


}