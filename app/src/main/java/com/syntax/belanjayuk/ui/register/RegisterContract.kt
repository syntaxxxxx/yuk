package com.syntax.belanjayuk.ui.register

import com.syntax.belanjayuk.base.BaseView

interface RegisterContract {

    interface Presenter {
        fun doRegister(firstName: String, lastName: String, email: String, password: String, confPassword: String)

    }

    interface View : BaseView {
        fun isEmptyField()
        fun isNotSamePassword()
        fun isSuccess(msg : String)
        fun onShowError(msg : String)
    }
}