package com.elpan.app.application.input

import com.elpan.app.domain.model.User
import com.elpan.app.domain.repository.UserRepositoryPort
import com.elpan.app.domain.service.FindOneUserService

class FindOneUserUseCase(private val userRepositoryPort: UserRepositoryPort) : FindOneUserService {
    override suspend fun findOne(id: String): User? = userRepositoryPort.findOne(id)

}