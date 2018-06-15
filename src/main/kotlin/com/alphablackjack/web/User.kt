package com.alphablackjack.web

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long,
                val email: String,
                val password: String,
                val enabled: Boolean = true)