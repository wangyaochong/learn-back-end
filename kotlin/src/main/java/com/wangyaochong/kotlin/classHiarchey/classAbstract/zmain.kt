package com.wangyaochong.kotlin.classHiarchey.classAbstract

/**
 *@author wangyaochong
 *@date 2020/4/23 07:10
 */

fun main(args: Array<String>) {
    val cat = Cat();
    cat.speak()
    cat.sayType()

    val dogParalyzed = DogParalyzed()
    dogParalyzed.sayType()
    dogParalyzed.run()
    dogParalyzed.look()
    Dog.jump(dogParalyzed)

}