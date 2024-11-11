package org.godco.adapter.out.persistece.jpaRepository

import org.godco.adapter.out.persistece.entity.board.BoardEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BoardJpaRepository : JpaRepository<BoardEntity, Long> {
}