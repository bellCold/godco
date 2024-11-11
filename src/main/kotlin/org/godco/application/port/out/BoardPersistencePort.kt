package org.godco.application.port.out

import org.godco.domain.board.Board

interface BoardPersistencePort {
    fun save(board: Board): Board
    fun findAll(): List<Board>?
    fun findById(id: Long): Board?
}