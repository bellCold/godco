package org.godco

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GodCoApplication

fun main(args: Array<String>) {
    runApplication<GodCoApplication>(*args)
}
