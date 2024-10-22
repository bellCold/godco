package org.godco.application.port.`in`

import org.godco.application.port.LoginCommand
import org.godco.domain.member.LoginMember

interface LoginUseCase {
    fun login(loginCommand: LoginCommand): LoginMember
}