package com.syntax.belanjayuk.ui.register

import com.syntax.belanjayuk.base.BaseView

interface RegisterContract {

    interface Presenter {

        fun onFirstNameChanged(firstName: String)
        fun onLastNameChanged(lastName: String)
        fun onEmailChanged(email: String)
        fun onPasswordChanged(password: String)
        fun onPasswordConfirmChanged(confirmPassword: String)
        fun onRegister()

    }

    interface View : BaseView {

        fun showFirstNameEror()
        fun showLastNameError()
        fun showEmailError()
        fun showPasswordError()
        fun showConfirmPasswordError()
        fun showRegisterSuccess()
        fun showRegisterError(message: String)

    }
}