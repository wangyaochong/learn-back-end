package com.wangyaochong.kotlin.classHiarchey.classExtend

/**
 *@author wangyaochong
 *@date 2020/4/23 06:16
 */
class Square(width: Int, height: Int) : Rect(width, height) {
    constructor(width: Int, height: Int, name: String) : this(width, height) {
        println("name=$name")
    }

    override fun say() {
        println("this is a square")
    }
}

fun main(args: Array<String>) {
    val square = Square(2, 3);
    println("宽度=${square.width},高度=${square.height},面积=${square.getArea()}")
    square.say()
    val squareWithName = Square(2, 3, "名字");


}