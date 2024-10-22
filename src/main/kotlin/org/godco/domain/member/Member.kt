package org.godco.domain.member

class Member(
    val id: Long = 0,
    val name: String,
    val email: String,
    val password: String
) {
    fun isCorrectPassword(password: String): Boolean {
        return this.password == password
    }
}