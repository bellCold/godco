package org.godco.adapter.`in`.web.member

import jakarta.validation.Valid
import org.godco.adapter.`in`.web.member.requset.JoinMemberRequestDto
import org.godco.application.port.`in`.JoinMemberUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/members")
class MemberController(private val joinMemberUseCase: JoinMemberUseCase) {

    @PostMapping
    fun join(@Valid @RequestBody joinMemberRequestDto: JoinMemberRequestDto) {
        joinMemberUseCase.join(joinMemberRequestDto.toCommand())
    }
}