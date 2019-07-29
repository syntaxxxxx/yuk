package com.syntax.belanjayuk.data.repository

import com.syntax.belanjayuk.data.model.login.ResponseLogin
import com.syntax.belanjayuk.data.model.register.ResponseRegister
import retrofit2.Call

interface Repository {

    fun register(firstName: String, lastName: String, email: String, password: String): Call<ResponseRegister>
    fun login(email: String, password: String): Call<ResponseLogin>

}