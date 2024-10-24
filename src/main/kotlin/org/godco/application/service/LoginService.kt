package org.godco.application.service

import org.godco.adapter.out.persistece.MemberPersistenceAdapter
import org.godco.application.port.LoginCommand
import org.godco.application.port.`in`.LoginUseCase
import org.godco.domain.member.LoginMember
import org.godco.domain.member.Token
import org.godco.global.exception.ErrorCode
import org.godco.global.exception.GodCoException
import org.springframework.stereotype.Service

@Service
class LoginService(private val memberPersistenceAdapter: MemberPersistenceAdapter) : LoginUseCase {
    override fun login(loginCommand: LoginCommand): LoginMember {
        val member = memberPersistenceAdapter.findByEmail(loginCommand.email)

        if (member == null) {
            throw GodCoException(ErrorCode.NOT_EXIST_MEMBER, "Email ${loginCommand.email} does not exist")
        }

        if (!member.isCorrectPassword(loginCommand.password)) {
            throw GodCoException(ErrorCode.DOES_NOT_MATCH_MEMBER_INFORMATION)
        }

        return LoginMember(Token.of(member))
    }
}