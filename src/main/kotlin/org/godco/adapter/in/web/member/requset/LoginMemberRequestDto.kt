package org.godco.adapter.`in`.web.member.requset

import org.godco.application.port.LoginCommand

data class LoginMemberRequestDto(val email: String, val password: String) {
    fun toCommand(): LoginCommand {
        return LoginCommand(
            email = this.email,
            password = this.password
        )
    }
}
