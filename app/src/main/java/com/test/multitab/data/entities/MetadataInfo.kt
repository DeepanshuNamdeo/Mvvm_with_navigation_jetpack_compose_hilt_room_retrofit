package com.test.multitab.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MetadataInfo(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val eventType : UserEvenEnum,
    val user: User
)

enum class UserEvenEnum {
    CREATED,
    DELETED
}
