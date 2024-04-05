package com.elpan.app.infrastructure.plugins

import com.elpan.app.application.input.*
import com.elpan.app.infrastructure.adapter.input.userRouting
import com.elpan.app.infrastructure.adapter.output.persistence.UserRepositoryAdapter
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val userRepositoryAdapter = UserRepositoryAdapter()

    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        userRouting(
            createUserUseCase = CreateCreateUserUseCase(userRepositoryAdapter),
            deleteUserUseCase = DeleteUserUseCase(userRepositoryAdapter),
            findAllUsersUseCase = FindAllUsersUseCase(userRepositoryAdapter),
            findOneUserUseCase = FindOneUserUseCase(userRepositoryAdapter),
            updateUserUseCase = UpdateUserUseCase(userRepositoryAdapter),
        )
    }
}
