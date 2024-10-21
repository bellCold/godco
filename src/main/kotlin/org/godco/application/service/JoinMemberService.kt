package org.godco.application.service

import org.godco.application.port.JoinMemberCommend
import org.godco.application.port.`in`.JoinMemberUseCase
import org.godco.application.port.out.MemberPersistencePort
import org.godco.domain.member.Member
import org.springframework.stereotype.Service

@Service
class JoinMemberService(private val memberPersistencePort: MemberPersistencePort) : JoinMemberUseCase {
    override fun join(joinMemberCommend: JoinMemberCommend) {
        val member = Member(
            name = joinMemberCommend.name,
            email = joinMemberCommend.email
        )

        memberPersistencePort.save(member)
    }

}