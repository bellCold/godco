package org.godco.domain.member

class Member(
    val id: Long = 0,
    val name: String,
    val email: String,
    val password: String,
    var phoneNumber: String,
    var status: MemberStatus = MemberStatus.OK,
) {
    fun isCorrectPassword(password: String): Boolean {
        return this.password == password
    }

    fun quit() {
        this.status = MemberStatus.QUIT
    }

    fun update(phoneNumber: String) {
        this.phoneNumber = phoneNumber
    }
}

enum class MemberStatus(val description: String) {
    OK("정상"),
    QUIT("탈퇴"),
    ;
}