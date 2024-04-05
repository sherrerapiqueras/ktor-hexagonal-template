package com.elpan.app.infrastructure.adapter.input.mapper

import com.elpan.app.domain.model.User
import com.elpan.app.infrastructure.adapter.input.data.request.CreateUserRequest
import com.elpan.app.infrastructure.adapter.input.data.request.UpdateUserRequest
import com.elpan.app.infrastructure.adapter.input.data.response.GetAllUsersResponse
import com.elpan.app.infrastructure.adapter.input.data.response.GetUserByIdResponse

object UserRoutingMapper {
    fun toUser(createUserRequest: CreateUserRequest): User = User(
        username = createUserRequest.username,
        password = createUserRequest.password,
        email = createUserRequest.email,
        name = createUserRequest.name,
        lastName = createUserRequest.lastName
    )

    fun toUser(updateUserRequest: UpdateUserRequest): User = User(
        id = updateUserRequest.id,
        username = updateUserRequest.username,
        password = updateUserRequest.password,
        email = updateUserRequest.email,
        name = updateUserRequest.name,
        lastName = updateUserRequest.lastName
    )

    fun toGetAllUserResponse(users: List<User>) = users.map { user ->
        GetAllUsersResponse(
            id = user.id!!,
            username = user.username,
            email = user.email,
        )
    }

    fun toGetUserByIdResponse(user: User) = GetUserByIdResponse(
        id = user.id!!,
        username = user.username,
        email = user.email,
    )
}