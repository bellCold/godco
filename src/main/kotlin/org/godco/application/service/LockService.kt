package org.godco.application.service

import org.godco.application.port.CachePort
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class LockService(private val cachePort: CachePort) {

    fun <T> lockScope(key: String, lockTimeoutSeconds: Long = 10, block: () -> T): T {
        return run {
            lock(key, lockTimeoutSeconds)
            block()
        }.also {
            unLock(key)
        }
    }

    fun <T> lockScope(keys: List<String>, lockTimeoutSeconds: Long = 10, block: () -> T): T {
        return run {
            keys.forEach { key ->
                lock(key, lockTimeoutSeconds)
            }
            block()
        }.also {
            keys.forEach { key ->
                unLock(key)
            }
        }
    }

    fun lock(key: String, lockTimeoutSeconds: Long) {
        val lockKey = createLockKey(key)
        val acquiredLock = cachePort.put(lockKey to "LOCKED", lockTimeoutSeconds, TimeUnit.SECONDS)

        if (acquiredLock != true) {
            throw IllegalStateException("Unable to acquire lock lockKey:$lockKey")
        }
    }

    fun unLock(key: String) {
        val lockKey = createLockKey(key)

        cachePort.delete(lockKey)
    }

    private fun createLockKey(key: String): String {
        return "lock:$key"
    }
}