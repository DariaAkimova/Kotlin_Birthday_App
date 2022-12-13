package com.adv.kotlin_birthday_app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "friendData")
data class Item (
    @PrimaryKey(autoGenerate = true) var id: Int,
    var name: String,
    var date: String)