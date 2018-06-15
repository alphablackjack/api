package com.alphablackjack.web

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority


class UserDetailsServiceImpl() : UserDetailsService {

    @Autowired
    private val userRepository: UserRepository? = null

    // TODO - Cache things.
//    @Autowired
//    private val cache: Cache? = null

    @Autowired
    private val objectMapper: ObjectMapper? = null


    override fun loadUserByUsername(username: String?): UserDetails {
        val grantedAuthorities = HashSet<GrantedAuthority>()
        grantedAuthorities.add(SimpleGrantedAuthority("admin"))

        return User("email", "password", grantedAuthorities)
    }

}