package com.example.challange8.data.local.model.response

import androidx.room.*

@Dao
interface DataUserDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUser(user: DataUser)

    @Query("SELECT * FROM data_user WHERE email = :email AND password = :password LIMIT 1")
    fun loginUser(email: String?, password: String?): DataUser

    @Query("SELECT EXISTS (SELECT 1 FROM data_user WHERE email = :email)")
    fun checkUser(email: String): Int

    @Query("SELECT * FROM data_user WHERE email = :email LIMIT 1")
    fun getUser(email: String?): DataUser

    @Update
    suspend fun updateProfileUser(user: DataUser)

    @Delete
    suspend fun deleteUser(user: DataUser): Int
}