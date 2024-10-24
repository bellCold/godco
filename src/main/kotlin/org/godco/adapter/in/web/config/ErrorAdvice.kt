package org.godco.adapter.`in`.web.config

import jakarta.servlet.http.HttpServletRequest
import org.godco.global.GodCoLogger
import org.godco.global.exception.ErrorCode
import org.godco.global.exception.GodCoException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorAdvice {
    companion object : GodCoLogger

    @ExceptionHandler(GodCoException::class)
    fun godCoException(request: HttpServletRequest, e: GodCoException): ResponseEntity<ErrorResponse> {
        log.error("@@ERROR@@ errorCode:${e.errorCode.name}, errorMessage:${e.errorCode.message}", e)
        return ResponseEntity
            .status(e.errorCode.httpStatusCode)
            .body(ErrorResponse(e.errorCode))
    }

    @ExceptionHandler(Exception::class)
    fun internalException(request: HttpServletRequest, e: Exception): ResponseEntity<ErrorResponse> {
        log.error("@@ERROR@@ internal server error", e)
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR))
    }

    class ErrorResponse(
        val code: String,
        val message: String
    ) {
        constructor(errorCode: ErrorCode) : this(errorCode.name, errorCode.message)
    }
}