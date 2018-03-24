package com.alphablackjack.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController(val repository: UserRepository) {

    @RequestMapping(value = "/")
    fun index(): String {
        return "index.html"
    }

    @RequestMapping(value = "/all")
    fun findAll() = repository.findAll()

}