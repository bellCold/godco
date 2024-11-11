package org.godco.adapter.out.persistece.entity.board

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.godco.domain.board.Board

@Entity
class BoardEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String,
    val content: String
) {
    fun toDomain() :Board {
        return Board(id, title, content)
    }

    companion object {
        fun of(board: Board): BoardEntity {
            return BoardEntity(
                title = board.title,
                content = board.content
            )
        }
    }
}