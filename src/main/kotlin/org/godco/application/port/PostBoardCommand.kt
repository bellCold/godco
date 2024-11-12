package org.godco.application.port

data class PostBoardCommand(val memberId: Long, val title: String, val content: String)
