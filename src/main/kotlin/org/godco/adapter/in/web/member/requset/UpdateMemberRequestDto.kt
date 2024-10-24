package org.godco.adapter.`in`.web.member.requset

import org.godco.application.port.UpdateMemberCommand

data class UpdateMemberRequestDto(val memberId: Long, val phoneNumber: String) {
    fun toCommand(): UpdateMemberCommand {
        return UpdateMemberCommand(this.memberId, this.phoneNumber)
    }

}
