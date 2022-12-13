package com.adv.kotlin_birthday_app.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.adv.kotlin_birthday_app.model.FriendData

@Dao
    interface FriendDataDao {

        @Query("select * from friendData")
        fun getAll(): LiveData<List<FriendEntity>>

        @Insert(onConflict = OnConflictStrategy.REPLACE)

//        fun insert(FriendData: FriendEntity)
        suspend fun insert(entity: FriendEntity)

        @Delete
        fun delete (FriendData : FriendEntity)
    }
