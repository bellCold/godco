package org.godco.adapter.out.persistece

import org.godco.adapter.out.persistece.entity.member.MemberEntity
import org.godco.adapter.out.persistece.jpaRepository.MemberJpaRepository
import org.godco.application.port.out.MemberPersistencePort
import org.godco.domain.member.Member
import org.springframework.stereotype.Repository

@Repository
class MemberPersistenceAdapter(private val memberJpaRepository: MemberJpaRepository) : MemberPersistencePort {
    override fun save(member: Member): Member {
        return memberJpaRepository.save(MemberEntity.of(member)).toDomain()
    }

    override fun findByEmail(email: String): Member? {
          return memberJpaRepository.findByEmail(email)?.toDomain()
    }
}