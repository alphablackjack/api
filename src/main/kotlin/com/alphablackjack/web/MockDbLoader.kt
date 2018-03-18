package com.alphablackjack.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Component
class MockDbLoader @Autowired constructor(private val userRepository: UserRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val user = User(12315235L, "John", "Dough", 25, "johndollr@gmail.com")
        userRepository.save(user)
    }

}