package org.godco.adapter.`in`.web.config

import org.godco.adapter.`in`.web.member.LoginMember
import org.godco.adapter.`in`.web.member.LoginMemberInfo
import org.godco.application.port.out.MemberPersistencePort
import org.godco.domain.member.MemberStatus
import org.godco.domain.member.Token
import org.godco.global.exception.ErrorCode
import org.godco.global.exception.GodCoException
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class LoginMemberArgumentResolver(private val memberPersistencePort: MemberPersistencePort) :
    HandlerMethodArgumentResolver {

    companion object {
        const val TOKEN_HEADER = "x-godco-token"
    }

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.getParameterAnnotation(LoginMember::class.java) != null && parameter.parameterType == LoginMemberInfo::class.java
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        val loginToken = webRequest.getHeader(TOKEN_HEADER) ?: throw GodCoException(ErrorCode.NOT_EXIST_TOKEN)
        val loginMemberInfo = Token(loginToken).getLoginMemberInfo()
        val member = memberPersistencePort.findById(loginMemberInfo.memberId) ?: throw GodCoException(ErrorCode.NOT_EXIST_MEMBER)

        if (loginMemberInfo.memberStatus == MemberStatus.OK || member.status == MemberStatus.OK) {
            return loginMemberInfo
        } else {
            throw GodCoException(ErrorCode.UNAUTHORIZED)
        }
    }
}