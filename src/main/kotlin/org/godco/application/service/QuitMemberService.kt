package org.godco.application.service

import org.godco.application.port.QuitMemberCommand
import org.godco.application.port.`in`.QuitMemberUseCase
import org.godco.application.port.out.MemberPersistencePort
import org.godco.global.exception.ErrorCode
import org.godco.global.exception.GodCoException
import org.springframework.stereotype.Service

@Service
class QuitMemberService(private val memberPersistencePort: MemberPersistencePort) : QuitMemberUseCase {
    override fun quit(quitMemberCommand: QuitMemberCommand) {
        val member = memberPersistencePort.findById(quitMemberCommand.memberId) ?: throw GodCoException(ErrorCode.NOT_EXIST_MEMBER)

        member.quit()

        memberPersistencePort.save(member)
    }

}