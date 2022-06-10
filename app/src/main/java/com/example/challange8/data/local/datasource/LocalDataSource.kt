package com.example.challange8.data.local.datasource

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun registerUser(dataUser: DataUser)
    suspend fun loginUser(email: String?, password: String?): DataUser
    suspend fun checkUser(email: String): Int
    suspend fun getUserData(username: String): DataUser
    suspend fun updateUser(dataUser: DataUserEntity)
    suspend fun getUserSession(): Flow<UserPreference>
    suspend fun saveUserSession(userPreference: UserPreference)
    suspend fun clearSession()
}