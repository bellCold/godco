package org.godco.global.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode

enum class ErrorCode(val httpStatusCode: HttpStatusCode, val message: String) {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "Duplicate Email"),
    NOT_EXIST_MEMBER(HttpStatus.NOT_FOUND, "Not Existing Member"),
    DOES_NOT_MATCH_MEMBER_INFORMATION(HttpStatus.NOT_FOUND, "Not Existing Member Information"),
    NOT_EXIST_TOKEN(HttpStatus.BAD_REQUEST, "Not Existing Token"),
    EXPIRED_TOKEN(HttpStatus.FORBIDDEN, "Expired Token"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Unauthorized"),
    ;
}
