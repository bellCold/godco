package org.godco.application.port.`in`

import org.godco.application.PostBoardCommand
import org.godco.domain.board.Board

interface PostBoardUseCase {
    fun post(postBoardCommand: PostBoardCommand): Board
}