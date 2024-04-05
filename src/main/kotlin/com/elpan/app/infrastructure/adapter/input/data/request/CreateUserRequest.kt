package com.elpan.app.infrastructure.adapter.input.data.request

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequest(
    val username: String,
    val password: String,
    val email: String,
    val name: String,
    val lastName: String
)

