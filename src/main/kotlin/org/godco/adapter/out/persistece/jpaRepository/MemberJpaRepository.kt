package org.godco.adapter.out.persistece.jpaRepository

import org.godco.adapter.out.persistece.entity.member.MemberEntity
import org.godco.domain.member.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository : JpaRepository<MemberEntity, Long> {
}