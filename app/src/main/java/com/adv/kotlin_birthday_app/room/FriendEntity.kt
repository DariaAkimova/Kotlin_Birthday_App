package com.adv.kotlin_birthday_app.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "friendData")
data class FriendEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
//    @PrimaryKey(autoGenerate = false)
    var name: String,
    var date: String,
    var idea: String)
