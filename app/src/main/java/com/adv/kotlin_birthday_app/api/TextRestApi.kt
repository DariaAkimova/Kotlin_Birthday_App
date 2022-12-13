package com.adv.kotlin_birthday_app.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TextRestApi {
    companion object {

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        fun getService(): TextService{
            return retrofit.create(TextService::class.java)
        }
    }
}