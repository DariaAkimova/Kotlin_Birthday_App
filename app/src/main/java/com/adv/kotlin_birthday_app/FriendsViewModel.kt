package com.adv.kotlin_birthday_app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.adv.kotlin_birthday_app.model.FriendRepository
import com.adv.kotlin_birthday_app.room.FriendEntity
import com.adv.kotlin_birthday_app.room.LocalDb
import kotlinx.coroutines.launch

class FriendsViewModel(application: Application) : AndroidViewModel(application) {

    private var friends: LiveData<List<FriendEntity>>? = null

//    var newFriends: MutableLiveData<FriendEntity> = MutableLiveData()

    private val repository: FriendRepository
    init {
             val dao = Room.databaseBuilder(application.applicationContext, LocalDb::class.java, "friendData")
            .fallbackToDestructiveMigration()
            .build()
            .friendDataDao()
        repository = FriendRepository(dao)
    }


    fun getAll(): LiveData<List<FriendEntity>>? {
        if (friends == null){
            friends = repository.getAll()
        }
        return friends
    }

    fun insert(vararg friendData: FriendEntity){
        viewModelScope.launch {
            repository.insert(*friendData)
        }
    }

    }

