package com.shashank.day12

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.measureTime

fun main() {
    // Lifecycle Scope ->
    // GlobalScope (Not use)
    // Coroutine Scope
    //ViewModelScope
    val time = measureTime {
        runBlocking {
            launch {
                println(fetchData1())
            }
            launch {
                println(fetchData2())
            }
        }
    }
    println("Execution time: $time")
}


suspend fun fetchData1(): String {
    delay(3000)
    return "Data fetched successfully 1"
}

suspend fun fetchData2(): String {
    delay(1000)
    return "Data fetched successfully 2"
}
