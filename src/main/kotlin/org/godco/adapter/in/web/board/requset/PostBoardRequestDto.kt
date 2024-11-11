package org.godco.adapter.`in`.web.board.requset

import org.godco.application.port.PostBoardCommand

data class PostBoardRequestDto(val title: String, val content: String) {
    fun toCommand(): PostBoardCommand {
        return PostBoardCommand(
            title = title,
            content = content
        )
    }
}
