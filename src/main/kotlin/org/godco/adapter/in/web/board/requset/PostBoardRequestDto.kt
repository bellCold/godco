package org.godco.adapter.`in`.web.board.requset

import org.godco.application.port.PostBoardCommand

data class PostBoardRequestDto(val title: String, val content: String) {
    fun toCommand(memberId: Long): PostBoardCommand {
        return PostBoardCommand(
            memberId = memberId,
            title = title,
            content = content
        )
    }
}
