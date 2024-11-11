package org.godco.adapter.`in`.web.board.response

import org.godco.domain.board.Board

data class BoardsResponseDto(val boards: List<BoardDto>) {
    companion object {
        fun from(boards: List<Board>): BoardsResponseDto {
            return BoardsResponseDto(
                boards = boards.map { board -> BoardDto(id = board.id, title = board.title) }
            )
        }
    }
}

data class BoardDto(val id: Long, val title: String)
