package com.elpan.app.application.input

import com.elpan.app.domain.repository.UserRepositoryPort
import com.elpan.app.domain.service.DeleteUserService

class DeleteUserUseCase(private val userRepositoryPort: UserRepositoryPort) : DeleteUserService {

    override suspend fun delete(id: String) = userRepositoryPort.deleteUser(id)
}