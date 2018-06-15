package com.alphablackjack.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class AccountController {

    @RequestMapping(value = "/login", method = [RequestMethod.POST])
    fun login(@RequestBody user: User) : String {

        if (user.email.isEmpty() || user.password.isEmpty()) {
            return "ERrrrrr."
        }


        return "Success."
    }

}