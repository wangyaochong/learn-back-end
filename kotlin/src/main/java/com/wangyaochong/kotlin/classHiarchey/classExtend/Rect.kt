package com.wangyaochong.kotlin.classHiarchey.classExtend

import mu.KotlinLogging

/**
 *@author wangyaochong
 *@date 2020/4/23 06:06
 */
private val log = KotlinLogging.logger {}

open class Rect(open var width: Int, open var height: Int) {
    fun getArea() = width * height
    open fun say() = println("this is a rect")
    fun say(str: String) = println("say param = $str")
}

fun main(args: Array<String>) {
    val rect = Rect(2, 3);
    println("宽度=${rect.width},高度=${rect.height},面积=${rect.getArea()}")
    log.info("打印日志")
}
