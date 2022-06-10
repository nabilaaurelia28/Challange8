package com.example.challange8.data.local.datasource

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourcelmpl @Inject constructor(
    private val dataUserDao: DataUserDao,
    private val datastorePreferences: DatastorePrefences
): LocalDataSource{
    override suspend fun registerUser(dataUser: DataUser) {
        return dataUserDao.insertDataUser(dataUser)
    }

    override suspend fun loginUser(email: String?, password: String?): DataUser {
        return dataUserDao.loginUser(email,password)
    }

    override suspend fun checkUser(email: String): Int {
        return dataUserDao.checkUser(email)
    }

    override suspend fun getUserData(email: String): DataUser {
        return dataUserDao.getEmail(email)
    }

    override suspend fun updateUser(dataUser: DataUserEntity) {
        return dataUserDao.updateProfileUser(dataUserEntity)

    }

    override suspend fun getUserSession(): Flow<UserPreference> {
        return datastorePreferences.saveUserSession(userPreferences)
    }

    override suspend fun saveUserSession(userPreference: UserPreference) {
        datastorePreferences.saveUserSession(userPreference)
    }

    override suspend fun clearSession() {
        datastorePreferences.deleteUserSession()
    }
}