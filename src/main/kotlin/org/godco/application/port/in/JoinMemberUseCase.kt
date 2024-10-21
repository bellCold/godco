package org.godco.application.port.`in`

import org.godco.application.port.JoinMemberCommand

interface JoinMemberUseCase {
    fun join(joinMemberCommand: JoinMemberCommand)
}