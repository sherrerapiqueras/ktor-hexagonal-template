package com.elpan.app.domain.service

import com.elpan.app.domain.model.User

fun interface UpdateUserService {
    suspend fun update(user: User)
}