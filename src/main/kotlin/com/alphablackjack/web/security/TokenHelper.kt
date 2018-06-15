package com.alphablackjack.web.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*


@Component
class TokenHelper {

    val APP_NAME = "ABJ-Api"
    val SECRET = "AlphaSecretKey"
    val EXPIRES_IN = 86400 // 24hrs.
    val SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512


    fun getUsernameFromToken(token: String) : String {
        return getClaimsFromToken(token).subject
    }


    fun generateToken(username: String) : String {
        return Jwts.builder()
                .setIssuer(APP_NAME)
                .setSubject(username)
                .setIssuedAt(generateCurrentDate())
                .setExpiration(generateExpirationDate())
                .signWith(SIGNATURE_ALGORITHM, SECRET)
                .compact()
    }


    fun getClaimsFromToken(token: String) : Claims {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .body
    }


    private fun generateCurrentDate(): Date {
        return Date(Calendar.getInstance().timeInMillis)
    }


    private fun generateExpirationDate(): Date {
        return Date(Calendar.getInstance().timeInMillis + EXPIRES_IN * 1000)
    }

}