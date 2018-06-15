package com.alphablackjack.web.security

import com.alphablackjack.web.UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TokenAuthenticationFilter : OncePerRequestFilter() {

    private val BEARER = "Bearer "
    private val AUTH_HEADER= "Authentication"

    @Autowired
    var tokenHelper: TokenHelper = TokenHelper()

    var userDetailsService = UserDetailsServiceImpl()


    private fun getToken(request: HttpServletRequest) : String? {
        val authHeader = request.getHeader(AUTH_HEADER)
        if (authHeader.startsWith(BEARER)) {
            return authHeader.substring(7)
        }

        return null
    }


    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {

        val authToken = getToken(request)

        val username = tokenHelper.getUsernameFromToken(authToken!!)
        val userDetails = userDetailsService.loadUserByUsername(username)

        val authentication = TokenBasedAuthentication(userDetails)
        authentication.token = authToken
        SecurityContextHolder.getContext().authentication = authentication

        filterChain.doFilter(request, response)
    }

}