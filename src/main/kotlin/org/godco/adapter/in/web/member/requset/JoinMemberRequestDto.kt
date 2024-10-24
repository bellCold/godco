package org.godco.adapter.`in`.web.member.requset

import org.godco.application.port.JoinMemberCommand

data class JoinMemberRequestDto(
    val name: String,
    val email: String,
    val password: String,
    val phoneNumber: String
) {
    fun toCommand(): JoinMemberCommand {
        return JoinMemberCommand(
            name = this.name,
            email = this.email,
            password = this.password,
            phoneNumber = this.phoneNumber
        )
    }
}
