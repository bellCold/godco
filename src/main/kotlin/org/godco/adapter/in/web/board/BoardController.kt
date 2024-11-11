package org.godco.adapter.`in`.web.board

import org.godco.adapter.`in`.web.board.requset.PostBoardRequestDto
import org.godco.adapter.`in`.web.board.response.PostBoardResponseDto
import org.godco.application.port.`in`.PostBoardUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/boards")
class BoardController(private val postBoardUseCase: PostBoardUseCase) {
    @PostMapping
    fun post(@RequestBody postBoardRequestDto: PostBoardRequestDto): PostBoardResponseDto {
        val board = postBoardUseCase.post(postBoardRequestDto.toCommand())

        return PostBoardResponseDto(board.id)
    }
}