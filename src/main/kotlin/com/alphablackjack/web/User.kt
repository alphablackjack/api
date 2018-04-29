package com.alphablackjack.web

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long,
           val firstName: String,
           val lastName: String,
           val age: Int,
           val email: String)