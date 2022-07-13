package com.test.multitab.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val email: String,
    val gender: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1,
    val name: String,
    val status: String
)