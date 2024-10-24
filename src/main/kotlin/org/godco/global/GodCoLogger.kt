package org.godco.global

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface GodCoLogger {
    val log: Logger get() = LoggerFactory.getLogger(this.javaClass)
}