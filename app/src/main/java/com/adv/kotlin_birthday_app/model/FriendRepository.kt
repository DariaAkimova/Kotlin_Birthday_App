package com.adv.kotlin_birthday_app.model

import com.adv.kotlin_birthday_app.room.FriendDataDao
import com.adv.kotlin_birthday_app.room.FriendEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FriendRepository(private val dao: FriendDataDao) {


    private val list = dao.getAll()

    fun getAll() = list

    suspend fun insert(vararg friends: FriendEntity) {
        withContext(Dispatchers.IO) {
            friends.forEach {
                dao.insert(it)
            }
        }
    }
}


