package org.godco.adapter.out.persistece.entity.board

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.godco.adapter.out.persistece.entity.BaseTimeEntity
import org.godco.domain.board.Board

@Entity
class BoardTimeEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String,
    val content: String
) : BaseTimeEntity() {
    companion object {
        fun of(board: Board): BoardTimeEntity {
            return BoardTimeEntity(
                title = board.title,
                content = board.content
            )
        }
    }

    fun toDomain(): Board {
        return Board(
            id = this.id,
            title = this.title,
            content = this.content
        )
    }
}