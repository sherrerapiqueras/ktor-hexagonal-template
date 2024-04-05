package com.elpan.app.infrastructure.adapter.input.data.response

import kotlinx.serialization.Serializable

@Serializable
data class GetUserByIdResponse(
    val id: String,
    val username: String,
    val email: String,
)
