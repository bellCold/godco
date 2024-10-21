package org.godco.adapter.out.persistece.entity.member

import jakarta.persistence.*
import org.godco.domain.member.Member

@Entity
@Table(name = "member")
class MemberEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val email: String,
) {
    companion object {
        fun of(member: Member): MemberEntity {
            return MemberEntity(
                id = member.id,
                name = member.name,
                email = member.email
            )
        }
    }

    fun toDomain(): Member {
        return Member(
            id = this.id,
            name = this.name,
            email = this.email
        )
    }
}