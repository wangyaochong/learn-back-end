package com.wangyaochong.kotlin.classHiarchey.classAbstract

/**
 *@author wangyaochong
 *@date 2020/4/23 06:54
 */
class Cat() : Animal("Cat"), Run {
    override fun run() {
        println("cat running")
    }

    override fun speak() {
        println("喵喵喵")
    }
}

