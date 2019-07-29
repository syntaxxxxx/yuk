package com.syntax.belanjayuk.ui.register

import android.util.Log
import com.syntax.belanjayuk.base.BasePresenter
import com.syntax.belanjayuk.data.model.register.ResponseRegister
import com.syntax.belanjayuk.data.repository.Injection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(private var regisView: RegisterContract.View?) : BasePresenter<RegisterContract.View>,
    RegisterContract.Presenter {

    private val repository = Injection.provideRepository()

    override fun onAttach(view: RegisterContract.View) {
        regisView = view
    }

    override fun onDettach() {
        regisView = null
    }

    override fun doRegister(
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        confPassword: String
    ) {

        if (firstName.isEmpty() || lastName.isEmpty() ||
            email.isEmpty() || password.isEmpty() || confPassword.isEmpty()
        ) {
            regisView?.isEmptyField()

        } else if (password != confPassword) {
            regisView?.isNotSamePassword()

        } else {
            repository.register(firstName, lastName, email, password).enqueue(object : Callback<ResponseRegister> {
                override fun onResponse(call: Call<ResponseRegister>?, response: Response<ResponseRegister>?) {
                    if (response != null && response.isSuccessful) {
                        val success = response.body()?.isSuccess
                        val msg = response.body()?.message

                        if (success == true) {
                            val dataRegister = response.body()?.data
                            Log.d("TAG", dataRegister.toString())
                            regisView?.isSuccess(msg!!)
                        } else{
                            regisView?.onShowError(msg!!)
                        }

                    } else {
                        regisView?.onShowError(response?.errorBody().toString())
                    }
                }

                override fun onFailure(call: Call<ResponseRegister>?, t: Throwable?) {
                    regisView?.onShowError("Connection to ${t?.message} failure")
                }
            })
        }
    }
}