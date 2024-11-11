package org.godco.application.port.`in`

import org.godco.application.FindBoardCommand
import org.godco.application.port.DeleteBoardCommand
import org.godco.domain.board.Board

interface BoardQueryUseCase {
    fun findAll(): List<Board>
    fun findById(findBoardCommand: FindBoardCommand): Board
    fun delete(deleteBoardCommand: DeleteBoardCommand)
}