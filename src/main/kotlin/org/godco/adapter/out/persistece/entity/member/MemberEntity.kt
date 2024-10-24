package org.godco.adapter.out.persistece.entity.member

import jakarta.persistence.*
import org.godco.domain.member.Member
import org.godco.domain.member.MemberStatus

@Entity
@Table(name = "member")
class MemberEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    @Enumerated(EnumType.STRING)
    val status: MemberStatus
) {
    companion object {
        fun of(member: Member): MemberEntity {
            return MemberEntity(
                id = member.id,
                name = member.name,
                email = member.email,
                password = member.password,
                phoneNumber = member.phoneNumber,
                status = member.status
            )
        }
    }

    fun toDomain(): Member {
        return Member(
            id = this.id,
            name = this.name,
            email = this.email,
            password = this.password,
            phoneNumber = this.phoneNumber,
            status = this.status
        )
    }
}