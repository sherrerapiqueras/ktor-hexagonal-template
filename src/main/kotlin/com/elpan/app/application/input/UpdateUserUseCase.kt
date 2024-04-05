package com.elpan.app.application.input

import com.elpan.app.domain.model.User
import com.elpan.app.domain.repository.UserRepositoryPort
import com.elpan.app.domain.service.UpdateUserService

class UpdateUserUseCase(private val userRepositoryPort: UserRepositoryPort) : UpdateUserService {
    override suspend fun update(user: User) = userRepositoryPort.updateUser(user)
}