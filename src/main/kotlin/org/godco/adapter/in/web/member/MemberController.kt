package org.godco.adapter.`in`.web.member

import jakarta.validation.Valid
import org.godco.adapter.`in`.web.member.requset.JoinMemberRequestDto
import org.godco.adapter.`in`.web.member.requset.LoginMemberRequestDto
import org.godco.adapter.`in`.web.member.response.LoginResponseDto
import org.godco.application.port.`in`.JoinMemberUseCase
import org.godco.application.port.`in`.LoginUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/members")
class MemberController(
    private val joinMemberUseCase: JoinMemberUseCase,
    private val loginUseCase: LoginUseCase
) {

    @PostMapping
    fun join(@Valid @RequestBody joinMemberRequestDto: JoinMemberRequestDto) {
        joinMemberUseCase.join(joinMemberRequestDto.toCommand())
    }

    @PostMapping("/login")
    fun login(@RequestBody loginMemberRequestDto: LoginMemberRequestDto): LoginResponseDto {
        val loginMember = loginUseCase.login(loginMemberRequestDto.toCommand())

        return LoginResponseDto(loginMember.id)
    }
}