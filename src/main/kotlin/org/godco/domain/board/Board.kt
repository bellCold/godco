package org.godco.domain.board

class Board(
    val id: Long = 0,
    val title: String,
    val content: String,
    var isDeleted: Boolean = false
) {
    fun delete(): Board {
        this.isDeleted = true
        return this
    }
}