package com.wangyaochong.kotlin.classHiarchey.classAbstract

/**
 *@author wangyaochong
 *@date 2020/4/23 07:07
 */
class DogParalyzed() : Dog("DogParalyzed"), Run by DogCar(), LookEarth by Earth {
//使用了DogCar进行run方法的代理，使用单例Earth进行look方法的代理
}