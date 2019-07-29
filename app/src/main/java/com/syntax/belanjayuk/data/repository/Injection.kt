package com.syntax.belanjayuk.data.repository

import com.syntax.belanjayuk.BuildConfig
import com.syntax.belanjayuk.data.model.login.ResponseLogin
import com.syntax.belanjayuk.data.model.register.ResponseRegister
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

object Injection {

    fun provideRepository(): Repository = RemoteRepository

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return loggingInterceptor
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder().addInterceptor(provideLoggingInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
        return okHttpClient
    }

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
    }

    fun provideBelanjaApi(): BelanjaApi = provideRetrofit().create(BelanjaApi::class.java)

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
}