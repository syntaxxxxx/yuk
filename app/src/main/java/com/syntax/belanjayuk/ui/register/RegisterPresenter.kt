package com.syntax.belanjayuk.ui.register

import com.syntax.belanjayuk.base.BasePresenter
import com.syntax.belanjayuk.model.Inputan
import com.syntax.belanjayuk.model.register.ResponseRegister
import com.syntax.belanjayuk.repository.Injection
import com.syntax.belanjayuk.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(private var regisView: RegisterContract.View?) : BasePresenter<RegisterContract.View>,
    RegisterContract.Presenter {

    private val repository = Injection.provideRepository()
    private val modelInput = Inputan()

    override fun onAttach(view: RegisterContract.View) {
        regisView = view
    }

    override fun onDettach() {
        regisView = null
    }

    override fun onFirstNameChanged(firstName: String) {
        modelInput.firstName = firstName
        if (!isFirstNameValid(firstName)) {
            regisView?.showFirstNameEror()
        }
    }

    override fun onLastNameChanged(lastName: String) {
        modelInput.lastName = lastName
        if (!isLastNameValid(lastName)) {
            regisView?.showLastNameError()
        }
    }

    override fun onEmailChanged(email: String) {
        modelInput.email = email
        if (!isEmailValid(email)) {
            regisView?.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        modelInput.password = password
        if (!isPasswordValid(password)) {
            regisView?.showPasswordError()
        }
    }

    override fun onPasswordConfirmChanged(confirmPassword: String) {
        modelInput.confirmPassword = confirmPassword
        if (!isConfirmPassword(modelInput.password, confirmPassword)) {
            regisView?.showConfirmPasswordError()
        }
    }

    override fun onRegister() {
        if (modelInput.isValid()) {

            val (firstName, lastName, email, password) = modelInput

            repository.register(firstName, lastName, email, password).enqueue(object : Callback<ResponseRegister> {

                override fun onResponse(call: Call<ResponseRegister>?, response: Response<ResponseRegister>?) {
                    if (response != null && response.isSuccessful) {
                        val dataRegister = response.body()?.data
                    } else {
                        regisView?.showRegisterError(response?.body()?.message.toString())
                    }
                }

                override fun onFailure(call: Call<ResponseRegister>?, t: Throwable?) {
                    regisView?.showRegisterError("Connection to ${t?.message} failure")
                }
            })
        }
    }
}