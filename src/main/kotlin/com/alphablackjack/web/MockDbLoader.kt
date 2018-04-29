package com.alphablackjack.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Component
class MockDbLoader @Autowired constructor(private val userRepository: UserRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val user0 = User(12315235L, "John", "Dough", 25, "johndollr@gmail.com")
        val user1 = User(12315236L, "Roger", "Who", 39, "rodge@gmail.com")
        val user2 = User(12315237L, "Billy", "Boy", 19, "billyboy@gmail.com")
        val user3 = User(12315238L, "Jane", "Jane", 59, "jane@gmail.com")
        val user4 = User(12315239L, "Rook", "Ladybird", 42, "ladybird@gmail.com")

        userRepository.saveAll(listOf(user0, user1, user2, user3, user4))
    }

}