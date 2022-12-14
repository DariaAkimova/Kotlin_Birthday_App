package com.adv.kotlin_birthday_app.room

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FriendEntity::class],
    version = 2
)
abstract class LocalDb : RoomDatabase() {
    abstract fun friendDataDao(): FriendDataDao
}