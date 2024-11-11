package org.godco.adapter.out.persistece.jpaRepository

import org.godco.adapter.out.persistece.entity.board.BoardTimeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BoardJpaRepository : JpaRepository<BoardTimeEntity, Long> {
}