package com.syntax.belanjayuk.repository

import com.syntax.belanjayuk.model.login.ResponseLogin
import com.syntax.belanjayuk.model.register.ResponseRegister
import retrofit2.Call

interface Repository {

    fun register(firstName: String, lastName: String, email: String, password: String): Call<ResponseRegister>
    fun login(email: String, password: String): Call<ResponseLogin>

}