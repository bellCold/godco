package org.godco.adapter.`in`.web.member

import jakarta.validation.Valid
import org.godco.adapter.`in`.web.member.requset.JoinMemberRequestDto
import org.godco.adapter.`in`.web.member.requset.LoginMemberRequestDto
import org.godco.adapter.`in`.web.member.requset.UpdateMemberRequestDto
import org.godco.adapter.`in`.web.member.response.LoginResponseDto
import org.godco.application.port.QuitMemberCommand
import org.godco.application.port.UpdateMemberCommand
import org.godco.application.port.`in`.JoinMemberUseCase
import org.godco.application.port.`in`.LoginUseCase
import org.godco.application.port.`in`.QuitMemberUseCase
import org.godco.application.port.`in`.UpdateMemberUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/members")
class MemberController(
    private val joinMemberUseCase: JoinMemberUseCase,
    private val quitMemberUseCase: QuitMemberUseCase,
    private val updateMemberUseCase: UpdateMemberUseCase,
    private val loginUseCase: LoginUseCase
) {

    @PostMapping("/join")
    fun join(@Valid @RequestBody joinMemberRequestDto: JoinMemberRequestDto) {
        joinMemberUseCase.join(joinMemberRequestDto.toCommand())
    }

    @PostMapping("/login")
    fun login(@RequestBody loginMemberRequestDto: LoginMemberRequestDto): LoginResponseDto {
        val loginMember = loginUseCase.login(loginMemberRequestDto.toCommand())

        return LoginResponseDto(loginMember.token)
    }

    @PutMapping("/quit")
    fun quit(@LoginMember loginMemberInfo: LoginMemberInfo) {
        quitMemberUseCase.quit(QuitMemberCommand(loginMemberInfo.memberId))
    }

    @PostMapping
    fun update(@LoginMember loginMemberInfo: LoginMemberInfo, @RequestBody updateMemberRequestDto: UpdateMemberRequestDto) {
        updateMemberUseCase.update(UpdateMemberCommand(loginMemberInfo.memberId, updateMemberRequestDto.phoneNumber))
    }
}