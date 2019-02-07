package com.bugsnag.example.kotlinmp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerApplication

fun main(args: Array<String>) {
    println(platformMessage())
    runApplication<ServerApplication>(*args)
}
