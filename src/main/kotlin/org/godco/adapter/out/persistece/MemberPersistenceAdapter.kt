package org.godco.adapter.out.persistece

import org.godco.adapter.out.persistece.entity.member.MemberTimeEntity
import org.godco.adapter.out.persistece.jpaRepository.MemberJpaRepository
import org.godco.application.port.out.MemberPersistencePort
import org.godco.domain.member.Member
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class MemberPersistenceAdapter(private val memberJpaRepository: MemberJpaRepository) : MemberPersistencePort {
    override fun save(member: Member): Member {
        return memberJpaRepository.save(MemberTimeEntity.of(member)).toDomain()
    }

    override fun findByEmail(email: String): Member? {
        return memberJpaRepository.findByEmail(email)?.toDomain()
    }

    override fun existEmail(email: String): Boolean {
        return memberJpaRepository.existsByEmail(email)
    }

    override fun findById(id: Long): Member? {
        return memberJpaRepository.findByIdOrNull(id)?.toDomain()
    }
}