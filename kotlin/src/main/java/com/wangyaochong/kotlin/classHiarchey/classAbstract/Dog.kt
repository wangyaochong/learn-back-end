package com.wangyaochong.kotlin.classHiarchey.classAbstract

/**
 *@author wangyaochong
 *@date 2020/4/23 06:56
 */
open class Dog(private var type: String = "Dog") : Animal(type), Run {
    companion object {
        fun jump(dog: Dog) {
            dog.sayType();
            println("dog jumping")
        }
    }

    override fun run() {
        println("dog running")
    }

    override fun speak() {
        println("汪汪汪")
    }
}