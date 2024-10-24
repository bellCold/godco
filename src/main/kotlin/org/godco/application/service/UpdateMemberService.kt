package org.godco.application.service

import org.godco.application.port.UpdateMemberCommand
import org.godco.application.port.`in`.UpdateMemberUseCase
import org.godco.application.port.out.MemberPersistencePort
import org.godco.global.exception.ErrorCode
import org.godco.global.exception.GodCoException
import org.springframework.stereotype.Service

@Service
class UpdateMemberService(private val memberPersistencePort: MemberPersistencePort) : UpdateMemberUseCase {
    override fun update(updateMemberCommand: UpdateMemberCommand) {
        val member = memberPersistencePort.findById(updateMemberCommand.memberId) ?: throw GodCoException(ErrorCode.NOT_EXIST_MEMBER)
        member.update(updateMemberCommand.phoneNumber)

        memberPersistencePort.save(member)
    }
}