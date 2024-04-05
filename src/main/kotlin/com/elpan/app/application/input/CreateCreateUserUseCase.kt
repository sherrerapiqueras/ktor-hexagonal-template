package com.elpan.app.application.input

import com.elpan.app.domain.model.User
import com.elpan.app.domain.repository.UserRepositoryPort
import com.elpan.app.domain.service.CreateUserService

class CreateCreateUserUseCase(
    private val userRepositoryPort: UserRepositoryPort
) : CreateUserService {

    override suspend fun create(user: User) {
        return userRepositoryPort.createUser(user)
    }
}