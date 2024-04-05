package com.elpan.app.domain.service

import com.elpan.app.domain.model.User

fun interface FindAllUsersService {
    suspend fun findAll(): List<User>
}