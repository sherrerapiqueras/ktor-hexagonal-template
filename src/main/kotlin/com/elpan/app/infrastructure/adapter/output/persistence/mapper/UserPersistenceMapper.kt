package com.elpan.app.infrastructure.adapter.output.persistence.mapper

import com.elpan.app.domain.model.User
import com.elpan.app.infrastructure.adapter.output.persistence.entity.UserDocument
import org.bson.types.ObjectId

object UserPersistenceMapper {
    fun toUser(userDocument: UserDocument): User = User(
        id = userDocument.id.toHexString(),
        username = userDocument.username,
        password = userDocument.password,
        email = userDocument.email,
        name = userDocument.name,
        lastName = userDocument.lastName
    )

    fun toUserDocument(user: User): UserDocument = UserDocument(
        id = user.id?.let { ObjectId(it) } ?: ObjectId(),
        username = user.username,
        password = user.password,
        email = user.email,
        name = user.name,
        lastName = user.lastName
    )
}