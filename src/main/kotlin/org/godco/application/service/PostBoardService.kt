package org.godco.application.service

import org.godco.application.port.PostBoardCommand
import org.godco.application.port.`in`.PostBoardUseCase
import org.godco.application.port.out.BoardPersistencePort
import org.godco.domain.board.Board
import org.springframework.stereotype.Service

@Service
class PostBoardService(private val boardPersistencePort: BoardPersistencePort) : PostBoardUseCase {

    override fun post(postBoardCommand: PostBoardCommand): Board {
        val board = Board(
            memberId = postBoardCommand.memberId,
            title = postBoardCommand.title,
            content = postBoardCommand.content,
        )

        return boardPersistencePort.save(board)
    }
}