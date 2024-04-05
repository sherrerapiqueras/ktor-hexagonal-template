package com.elpan.app.domain.model

data class User(
    val id: String? = null,
    val username: String,
    val password: String,
    val email: String,
    val name: String,
    val lastName: String
)