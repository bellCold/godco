package org.godco.application.service

import org.godco.application.port.JoinMemberCommand
import org.godco.application.port.`in`.JoinMemberUseCase
import org.godco.application.port.out.MemberPersistencePort
import org.godco.domain.member.Member
import org.springframework.stereotype.Service

@Service
class JoinMemberService(private val memberPersistencePort: MemberPersistencePort) : JoinMemberUseCase {
    override fun join(joinMemberCommand: JoinMemberCommand) {
        val member = Member(
            name = joinMemberCommand.name,
            email = joinMemberCommand.email
        )

        memberPersistencePort.save(member)
    }

}