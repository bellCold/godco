package org.godco.domain.member

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.godco.adapter.`in`.web.member.LoginMemberInfo
import org.godco.global.DEFAULT_OBJECT_MAPPER
import org.godco.global.exception.ErrorCode
import org.godco.global.exception.GodCoException
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@JvmInline
value class Token(
    val token: String
) {
    companion object {
        private const val PLAIN_SECRET_KEY = "godcosecretkeyJaISjiKkjaB"
        private val SECRET_KEY = Keys.hmacShaKeyFor(Base64.getEncoder().encode(PLAIN_SECRET_KEY.toByteArray()))

        fun of(loginMember: Member): Token {
            val jwtToken = createToken(loginMember)
            return Token(jwtToken)
        }

        private fun createToken(member: Member): String {
            return Jwts.builder()
                .header().add(mapOf("typ" to "JWT", "alg" to "HS256")).and()
                .claims().add(mapOf("memberId" to member.id, "email" to member.email, "memberStatus" to member.status))
                .and()
                .subject("user")
                .expiration(Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SECRET_KEY, Jwts.SIG.HS256)
                .compact()
        }
    }

    fun getLoginMemberInfo(): LoginMemberInfo {
        val claims = getClaims()

        return DEFAULT_OBJECT_MAPPER.convertValue(claims, LoginMemberInfo::class.java)
    }

    private fun getClaims(): Claims {
        return runCatching {
            Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .payload
        }.onFailure {
            when (it) {
                is ExpiredJwtException -> throw GodCoException(ErrorCode.EXPIRED_TOKEN)
                else -> throw it
            }
        }.getOrThrow()
    }

}