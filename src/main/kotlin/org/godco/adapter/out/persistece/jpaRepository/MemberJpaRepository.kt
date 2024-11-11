package org.godco.adapter.out.persistece.jpaRepository

import org.godco.adapter.out.persistece.entity.member.MemberTimeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository : JpaRepository<MemberTimeEntity, Long> {
    fun findByEmail(email: String): MemberTimeEntity?
    fun existsByEmail(email: String): Boolean
}