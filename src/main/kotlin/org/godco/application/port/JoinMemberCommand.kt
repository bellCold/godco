package org.godco.application.port

data class JoinMemberCommand(val name: String, val email: String, val password: String)
