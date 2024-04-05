package com.elpan.app.infrastructure.bean

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.ServerApi
import com.mongodb.ServerApiVersion
import com.mongodb.kotlin.client.coroutine.MongoClient

object MongoDBClient {
    private val CONNECTION_STRING = System.getenv("MONGO_CONNECTION_STRING")

    private val serverApi: ServerApi = ServerApi.builder()
        .version(ServerApiVersion.V1)
        .build()
    private val mongoClientSettings: MongoClientSettings = MongoClientSettings.builder()
        .applyConnectionString(ConnectionString(CONNECTION_STRING))
        .serverApi(serverApi)
        .build()

    fun getMongoClient(): MongoClient {
        return MongoClient.create(mongoClientSettings)
    }
}
