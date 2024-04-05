package com.elpan.app.infrastructure.adapter.output.persistence.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class UserDocument(
    @BsonId
    val id: ObjectId,
    val username: String,
    val password: String,
    val email: String,
    val name: String,
    val lastName: String
)