package com.adv.kotlin_birthday_app.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adv.kotlin_birthday_app.Item

@Database(entities = [Item::class], version = 1)
abstract class LocalDb : RoomDatabase() {
    abstract fun friendDataDao(): FriendDataDao
}