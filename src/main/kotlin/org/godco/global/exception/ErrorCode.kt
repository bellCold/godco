package org.godco.global.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode

enum class ErrorCode(val httpStatusCode: HttpStatusCode, val message: String) {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "Duplicate Email"),
    ;
}
