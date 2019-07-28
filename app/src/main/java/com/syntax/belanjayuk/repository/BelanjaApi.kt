package com.syntax.belanjayuk.repository

import com.syntax.belanjayuk.model.login.ResponseLogin
import com.syntax.belanjayuk.model.register.ResponseRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BelanjaApi {

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseRegister>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseLogin>

}