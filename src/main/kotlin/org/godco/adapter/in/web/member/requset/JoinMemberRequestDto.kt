package org.godco.adapter.`in`.web.member.requset

import org.godco.application.port.JoinMemberCommend

data class JoinMemberRequestDto(val name: String, val email: String) {
    fun toCommand(): JoinMemberCommend {
        return JoinMemberCommend(
            name = this.name,
            email = this.email
        )
    }
}
