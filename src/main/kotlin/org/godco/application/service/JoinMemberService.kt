package org.godco.application.service

import org.godco.application.port.JoinMemberCommand
import org.godco.application.port.`in`.JoinMemberUseCase
import org.godco.application.port.out.MemberPersistencePort
import org.godco.domain.member.Member
import org.godco.global.exception.ErrorCode
import org.godco.global.exception.GodCoException
import org.springframework.stereotype.Service

@Service
class JoinMemberService(
    private val memberPersistencePort: MemberPersistencePort,
    private val lockService: LockService,
) : JoinMemberUseCase {
    override fun join(joinMemberCommand: JoinMemberCommand) {
        lockService.lockScope(joinMemberCommand.email) {
            if (memberPersistencePort.existEmail(joinMemberCommand.email)) {
                throw GodCoException(ErrorCode.DUPLICATE_EMAIL)
            }

            val member = Member(
                name = joinMemberCommand.name,
                email = joinMemberCommand.email,
                password = joinMemberCommand.password
            )

            memberPersistencePort.save(member)
        }
    }
}