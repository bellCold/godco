package org.godco.adapter.out.persistece

import org.godco.adapter.out.persistece.entity.board.BoardTimeEntity
import org.godco.adapter.out.persistece.jpaRepository.BoardJpaRepository
import org.godco.application.port.out.BoardPersistencePort
import org.godco.domain.board.Board
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class BoardPersistenceAdapter(private val boardJpaRepository: BoardJpaRepository) : BoardPersistencePort {
    override fun save(board: Board): Board {
        return boardJpaRepository.save(BoardTimeEntity.of(board)).toDomain()
    }

    override fun findAll(): List<Board>? {
        return boardJpaRepository.findAll().map {
            Board(
                memberId = it.memberId,
                title = it.title,
                content = it.content,
            )
        }.toList()
    }

    override fun findById(boardId: Long): Board? {
        return boardJpaRepository.findByIdOrNull(boardId)?.toDomain()
    }
}