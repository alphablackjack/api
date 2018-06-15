package com.alphablackjack.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Component
class MockDbLoader @Autowired constructor(private val userRepository: UserRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val user0 = User(12315235L,"johndollr@gmail.com", "Password1")
        val user1 = User(12315236L,"rodge@gmail.com", "Password2")
        val user2 = User(12315237L, "billyboy@gmail.com", "Password3")
        val user3 = User(12315238L, "jane@gmail.com", "Password4")
        val user4 = User(12315239L, "ladybird@gmail.com", "Password5")

        userRepository.saveAll(listOf(user0, user1, user2, user3, user4))
    }

}