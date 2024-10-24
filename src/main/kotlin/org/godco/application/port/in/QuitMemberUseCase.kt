package org.godco.application.port.`in`

import org.godco.application.port.QuitMemberCommand

interface QuitMemberUseCase {
    fun quit(quitMemberCommand: QuitMemberCommand)
}