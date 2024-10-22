package org.godco.application.service

import org.godco.adapter.out.persistece.MemberPersistenceAdapter
import org.godco.application.port.LoginCommand
import org.godco.application.port.`in`.LoginUseCase
import org.godco.domain.member.LoginMember
import org.springframework.stereotype.Service

@Service
class LoginService(private val memberPersistenceAdapter: MemberPersistenceAdapter) : LoginUseCase {
    override fun login(loginCommand: LoginCommand): LoginMember {
        val member = memberPersistenceAdapter.findByEmail(loginCommand.email)

        if (member == null) {
            throw RuntimeException("Email ${loginCommand.email} does not exist")
        }

        if(!member.isCorrectPassword(loginCommand.password)) {
            throw RuntimeException("Passwords do not match")
        }

        return LoginMember(member.id)
    }
}