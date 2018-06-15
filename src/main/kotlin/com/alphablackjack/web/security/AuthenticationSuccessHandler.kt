package com.alphablackjack.web.security

import org.apache.catalina.manager.StatusTransformer.setContentType
import javax.servlet.http.HttpServletResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest


@Component
class AuthenticationSuccessHandler : SimpleUrlAuthenticationSuccessHandler() {

    @Autowired
    internal var tokenHelper: TokenHelper? = null

    @Autowired
    internal var objectMapper: ObjectMapper? = null

    val EXPIRES_IN = 86400 // 24hrs.

    override fun onAuthenticationSuccess(
            request: HttpServletRequest,
            response: HttpServletResponse,
            authentication: Authentication
    ) {

        clearAuthenticationAttributes(request)
        val user = authentication.principal as User
        val jwt = tokenHelper!!.generateToken(user.username)

        val userTokenState = UserTokenState(jwt, EXPIRES_IN)
        try {
            val jwtResponse = objectMapper!!.writeValueAsString(userTokenState)
            response.contentType = "application/json"
            response.writer.write(jwtResponse)
        } catch (e: Exception) {
            println(e.message)
        }

    }

    private inner class UserTokenState(var jws: String?, var expires: Int)
}