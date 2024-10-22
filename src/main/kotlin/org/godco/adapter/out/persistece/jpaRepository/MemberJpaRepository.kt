package org.godco.adapter.out.persistece.jpaRepository

import org.godco.adapter.out.persistece.entity.member.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository : JpaRepository<MemberEntity, Long> {
    fun findByEmail(email: String): MemberEntity?
}