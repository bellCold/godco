package org.godco.application.port.`in`

import org.godco.application.port.JoinMemberCommend

interface JoinMemberUseCase {
    fun join(joinMemberCommend: JoinMemberCommend)
}