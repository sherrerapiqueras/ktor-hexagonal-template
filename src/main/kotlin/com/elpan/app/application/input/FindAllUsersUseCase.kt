package com.elpan.app.application.input

import com.elpan.app.domain.model.User
import com.elpan.app.domain.repository.UserRepositoryPort
import com.elpan.app.domain.service.FindAllUsersService

class FindAllUsersUseCase(private val userRepositoryPort: UserRepositoryPort) : FindAllUsersService {
    override suspend fun findAll(): List<User> = userRepositoryPort.findAll()
}