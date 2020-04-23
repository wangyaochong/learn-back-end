package com.wangyaochong.kotlin

import kotlinx.coroutines.*
import mu.KotlinLogging

/**
 *@author wangyaochong
 *@date 2020/4/23 18:00
 */

private val log = KotlinLogging.logger {}

//Dispatchers.IO是8倍可用线程数量
//Dispatchers.Default等于可用线程数量
suspend fun longTimeTask(count: Int) {
    withContext(Dispatchers.Default) {
        println("$count start execute longTimeTask")
        Thread.sleep(1000)
        println("$count end execute longTimeTask")
    }
}

fun test() = runBlocking {
    var arrayList = ArrayList<Deferred<Unit>>()
    repeat(10000) {
        val async = GlobalScope.async {
            longTimeTask(it);
        }
        arrayList.add(async)
    }
    arrayList.forEach { it.await() }
}

fun main(args: Array<String>) {
    test();
}