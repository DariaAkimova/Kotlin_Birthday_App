package com.adv.kotlin_birthday_app.room

import androidx.room.*
import com.adv.kotlin_birthday_app.Item

    @Dao
    interface FriendDataDao {

        @Query("select * from FriendData")
        fun getAll(): List<Item>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insert(Item: Item)

        @Delete
        fun delete (Item : Item)
    }
