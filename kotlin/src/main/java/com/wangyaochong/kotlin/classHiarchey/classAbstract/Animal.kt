package com.wangyaochong.kotlin.classHiarchey.classAbstract

/**
 *@author wangyaochong
 *@date 2020/4/23 06:48
 */
abstract class Animal(private var type: String) {
    abstract fun speak();
    fun sayType() = println("my type is $type")
}