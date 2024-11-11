package org.godco.application.service

import org.godco.application.port.FindBoardCommand
import org.godco.application.port.DeleteBoardCommand
import org.godco.application.port.`in`.BoardQueryUseCase
import org.godco.application.port.out.BoardPersistencePort
import org.godco.domain.board.Board
import org.godco.global.exception.ErrorCode
import org.godco.global.exception.GodCoException
import org.springframework.stereotype.Service

@Service
class BoardQueryService(private val boardPersistencePort: BoardPersistencePort) : BoardQueryUseCase {
    override fun findAll(): List<Board> {
        return boardPersistencePort.findAll() ?: emptyList()
    }

    override fun findById(findBoardCommand: FindBoardCommand): Board {
        return boardPersistencePort.findById(findBoardCommand.id) ?: throw GodCoException(ErrorCode.NOT_EXIST_BOARD)
    }

    override fun delete(deleteBoardCommand: DeleteBoardCommand) {
        val board = boardPersistencePort.findById(deleteBoardCommand.id)?.delete() ?: throw GodCoException(ErrorCode.NOT_EXIST_BOARD)

        boardPersistencePort.save(board)
    }
}