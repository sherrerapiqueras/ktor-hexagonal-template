package com.elpan.app.domain.service

import com.elpan.app.domain.model.User

fun interface FindOneUserService {
    suspend fun findOne(id: String): User?
}