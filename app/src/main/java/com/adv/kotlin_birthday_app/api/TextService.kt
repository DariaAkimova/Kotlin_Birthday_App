package com.adv.kotlin_birthday_app.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TextService {
    @GET("/posts/{id}")
    fun getById(@Path("id") id: Int) : Call<TextResponse>
}