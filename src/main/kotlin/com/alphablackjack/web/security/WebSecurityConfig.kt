package com.alphablackjack.web.security

import com.alphablackjack.web.UserDetailsServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.http.HttpMethod



@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.addFilterBefore(TokenAuthenticationFilter(), BasicAuthenticationFilter::class.java)
                ?.authorizeRequests()
                ?.antMatchers("/api/**")?.permitAll()
                ?.antMatchers("/swagger-ui.html")?.permitAll()
                ?.antMatchers("/webjars/**")?.permitAll()
                ?.antMatchers("/swagger-resources/**")?.permitAll()
                ?.anyRequest()?.authenticated()
                ?.anyRequest()?.hasAuthority("admin")
                ?.and()?.formLogin()?.successHandler(AuthenticationSuccessHandler())
                ?.failureHandler(AuthenticationFailureHandler())
                ?.and()?.csrf()?.disable()

    }

}