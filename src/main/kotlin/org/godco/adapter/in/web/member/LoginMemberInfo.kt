package org.godco.adapter.`in`.web.member

import org.godco.domain.member.MemberStatus

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class LoginMember

data class LoginMemberInfo(val memberId: Long, val email: String, val memberStatus: MemberStatus)
