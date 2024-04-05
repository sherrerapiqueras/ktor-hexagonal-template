package com.elpan.app.infrastructure.adapter.output.persistence

import com.elpan.app.domain.model.User
import com.elpan.app.domain.repository.UserRepositoryPort
import com.elpan.app.infrastructure.adapter.output.persistence.entity.UserDocument
import com.elpan.app.infrastructure.adapter.output.persistence.mapper.UserPersistenceMapper
import com.elpan.app.infrastructure.bean.MongoDBClient.getMongoClient
import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.Updates
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoCollection
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.bson.types.ObjectId

class UserRepositoryAdapter(
    mongoClient: MongoClient = getMongoClient(),
) : UserRepositoryPort {

    private val database: MongoDatabase = mongoClient.getDatabase("elpan")
    private val collection: MongoCollection<UserDocument> = database.getCollection("users")

    override suspend fun createUser(user: User) {
        collection.insertOne(UserPersistenceMapper.toUserDocument(user))
    }

    override suspend fun deleteUser(id: String) {
        collection.deleteOne(eq("_id", ObjectId(id)))
    }

    override suspend fun findAll(): List<User> {
        return collection
            .withDocumentClass<UserDocument>()
            .find()
            .toList().map { UserPersistenceMapper.toUser(it) }
    }

    override suspend fun findOne(id: String): User? {
        return collection
            .withDocumentClass<UserDocument>()
            .find(eq("_id", ObjectId(id))).map { UserPersistenceMapper.toUser(it) }
            .firstOrNull()
    }

    override suspend fun updateUser(user: User) {
        val query = eq("_id", ObjectId(user.id))
        val updates = Updates.combine(
            Updates.set(UserDocument::name.name, user.name),
            Updates.set(UserDocument::lastName.name, user.lastName),
            Updates.set(UserDocument::email.name, user.email)
        )
        collection.updateOne(query, updates)
    }
}