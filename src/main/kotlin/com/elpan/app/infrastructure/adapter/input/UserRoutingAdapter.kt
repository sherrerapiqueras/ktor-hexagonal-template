package com.elpan.app.infrastructure.adapter.input

import com.elpan.app.application.input.*
import com.elpan.app.infrastructure.adapter.input.data.request.CreateUserRequest
import com.elpan.app.infrastructure.adapter.input.data.request.UpdateUserRequest
import com.elpan.app.infrastructure.adapter.input.mapper.UserRoutingMapper
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRouting(
    createUserUseCase: CreateCreateUserUseCase,
    deleteUserUseCase: DeleteUserUseCase,
    findAllUsersUseCase: FindAllUsersUseCase,
    findOneUserUseCase: FindOneUserUseCase,
    updateUserUseCase: UpdateUserUseCase,
) {
    route("/users") {
        get {
            val users = findAllUsersUseCase.findAll()
            call.respond(UserRoutingMapper.toGetAllUserResponse(users))
        }
        get("{id?}") {
            call.parameters["id"] ?: return@get call.respondText(
                "Missing id", status = HttpStatusCode.BadRequest
            )
            val user = findOneUserUseCase.findOne(call.parameters["id"]!!) ?: return@get call.respond(
                HttpStatusCode.NotFound
            )
            call.respond(UserRoutingMapper.toGetUserByIdResponse(user))
        }
        post {
            val user = call.receive<CreateUserRequest>()
            createUserUseCase.create(UserRoutingMapper.toUser(user))
            call.respond(HttpStatusCode.Created)
        }
        put {
            val user = call.receive<UpdateUserRequest>()
            updateUserUseCase.update(UserRoutingMapper.toUser(user))
            call.respond(HttpStatusCode.OK)
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            deleteUserUseCase.delete(id)
            call.respond(HttpStatusCode.NoContent)
        }
    }
}
