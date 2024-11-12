package org.godco.adapter.`in`.web.board

import org.godco.adapter.`in`.web.board.requset.PostBoardRequestDto
import org.godco.adapter.`in`.web.board.response.BoardResponseDto
import org.godco.adapter.`in`.web.board.response.BoardsResponseDto
import org.godco.adapter.`in`.web.board.response.PostBoardResponseDto
import org.godco.adapter.`in`.web.member.LoginMember
import org.godco.adapter.`in`.web.member.LoginMemberInfo
import org.godco.application.port.FindBoardCommand
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
    fun post(@LoginMember loginMemberInfo: LoginMemberInfo, @RequestBody postBoardRequestDto: PostBoardRequestDto): PostBoardResponseDto {
        val board = postBoardUseCase.post(postBoardRequestDto.toCommand(loginMemberInfo.memberId))

        return PostBoardResponseDto(board.id)
    }

    @GetMapping
    fun findAll(): BoardsResponseDto {
        val boards = boardQueryUseCase.findAll()

        return BoardsResponseDto.from(boards)
    }

    @GetMapping("/{boardId}")
    fun findById(@PathVariable boardId: Long): BoardResponseDto {
        val board = boardQueryUseCase.findById(FindBoardCommand(boardId = boardId))

        return BoardResponseDto(
            id = board.id,
            title = board.title,
            content = board.content
        )
    }

    @DeleteMapping("/{boardId}")
    fun delete(@LoginMember loginMemberInfo: LoginMemberInfo, @PathVariable boardId: Long) {
        boardQueryUseCase.delete(DeleteBoardCommand(loginMemberInfo.memberId, boardId))
    }
}