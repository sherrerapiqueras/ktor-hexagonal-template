package com.elpan.app.domain.service

fun interface DeleteUserService {
    suspend fun delete(id: String)
}