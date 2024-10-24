package org.godco.application.port

data class UpdateMemberCommand(val memberId: Long, val phoneNumber: String)
