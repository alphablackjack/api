package com.alphablackjack.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val repository: UserRepository) {

    @RequestMapping(value = "/api/all")
    fun findAll() = repository.findAll()

}