package com.alphablackjack.web.security

import org.springframework.security.core.AuthenticationException
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletResponse
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest


@Component
class AuthenticationFailureHandler : SimpleUrlAuthenticationFailureHandler() {

    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationFailure(request: HttpServletRequest, response: HttpServletResponse,
                                         exception: AuthenticationException) {
        super.onAuthenticationFailure(request, response, exception)
    }
}