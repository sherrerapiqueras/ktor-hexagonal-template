package com.elpan.app.domain.service

import com.elpan.app.domain.model.User

fun interface CreateUserService {
    suspend fun create(user: User)
}