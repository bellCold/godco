package org.godco.application.port.`in`

import org.godco.application.port.UpdateMemberCommand

interface UpdateMemberUseCase {
    fun update(updateMemberCommand: UpdateMemberCommand)
}