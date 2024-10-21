package org.godco

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GodkoApplication

fun main(args: Array<String>) {
    runApplication<GodkoApplication>(*args)
}
