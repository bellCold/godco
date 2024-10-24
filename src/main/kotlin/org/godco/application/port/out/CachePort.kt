package org.godco.application.port.out

import java.util.concurrent.TimeUnit

interface CachePort {
    fun put(pair: Pair<String, String>, ttl: Long, timeUnit: TimeUnit): Boolean?
    fun delete(key: String)
}