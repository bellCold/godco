package org.godco.application.service

import org.godco.application.PostBoardCommand
import org.godco.application.port.`in`.PostBoardUseCase
import org.godco.application.port.out.BoardPersistencePort
import org.godco.domain.board.Board
import org.springframework.stereotype.Service

@Service
class PostBoardService(private val boardPersistencePort: BoardPersistencePort) : PostBoardUseCase {

    override fun post(postBoardCommand: PostBoardCommand): Board {
        val board = Board(
            title = postBoardCommand.title,
            content = postBoardCommand.content,
        )

        return boardPersistencePort.save(board)
    }
}