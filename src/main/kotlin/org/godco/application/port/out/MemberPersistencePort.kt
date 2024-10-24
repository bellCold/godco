package org.godco.application.port.out

import org.godco.domain.member.Member

interface MemberPersistencePort {
    fun save(member: Member): Member

    fun findByEmail(email: String): Member?

    fun existEmail(email: String): Boolean

    fun findById(id: Long): Member?
}