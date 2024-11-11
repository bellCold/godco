package org.godco.adapter.`in`.web.board

import org.godco.adapter.`in`.web.board.requset.PostBoardRequestDto
import org.godco.adapter.`in`.web.board.response.BoardResponseDto
import org.godco.adapter.`in`.web.board.response.BoardsResponseDto
import org.godco.adapter.`in`.web.board.response.PostBoardResponseDto
import org.godco.application.FindBoardCommand
import org.godco.application.port.DeleteBoardCommand
import org.godco.application.port.`in`.BoardQueryUseCase
import org.godco.application.port.`in`.PostBoardUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/boards")
class BoardController(
    private val postBoardUseCase: PostBoardUseCase,
    private val boardQueryUseCase: BoardQueryUseCase
) {
    @PostMapping
    fun post(@RequestBody postBoardRequestDto: PostBoardRequestDto): PostBoardResponseDto {
        val board = postBoardUseCase.post(postBoardRequestDto.toCommand())

        return PostBoardResponseDto(board.id)
    }

    @GetMapping
    fun findAll(): BoardsResponseDto {
        val boards = boardQueryUseCase.findAll()

        return BoardsResponseDto.from(boards)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): BoardResponseDto {
        val board = boardQueryUseCase.findById(FindBoardCommand(id = id))

        return BoardResponseDto(
            id = board.id,
            title = board.title,
            content = board.content
        )
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        boardQueryUseCase.delete(DeleteBoardCommand(id))
    }
}