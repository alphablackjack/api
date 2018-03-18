package com.alphablackjack.web

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class WebSecurityConfigAdapter : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.httpBasic()?.disable()
    }

}