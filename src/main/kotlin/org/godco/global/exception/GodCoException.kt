package org.godco.global.exception

class GodCoException(val errorCode: ErrorCode, message: String) : RuntimeException(message) {
    constructor(errorCode: ErrorCode) : this(errorCode, errorCode.message)
}