package com.example.challange8.data.local.model.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_user")
data class DataUser (
    @PrimaryKey(autoGenerate = true)
    val id : Int?,
    @ColumnInfo(name = "email")
    val email : String?,
    @ColumnInfo(name = "password")
    val password : String?,
    @ColumnInfo(name = "nama")
    val nama : String?,
    @ColumnInfo(name = "alamat")
    val alamat : String?,
    @ColumnInfo(name = "usia")
    val usia : Int?,
    @ColumnInfo(name= "profile_user")
    val profile: String?

)