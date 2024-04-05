package com.elpan.app.domain.repository

import com.elpan.app.domain.model.User

interface UserRepositoryPort {
    suspend fun createUser(user: User)
    suspend fun deleteUser(id: String)
    suspend fun findAll(): List<User>
    suspend fun findOne(id: String): User?
    suspend fun updateUser(user: User)
}