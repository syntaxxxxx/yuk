package com.syntax.belanjayuk.ui.login

import android.content.SharedPreferences
import com.syntax.belanjayuk.base.BaseView
import com.syntax.belanjayuk.data.model.login.Data

interface LoginContract {

    interface Presenter {
        fun doLogin(email: String, password: String)
        fun isRememberMe(sp: SharedPreferences?, isRemember: Boolean)
        fun saveToPreferences(
            sp: SharedPreferences?,
            id: String,
            email: String,
            firstName: String,
            lastName: String
        )
    }

    interface View : BaseView {
        fun onShowSuccess(data: Data?, msg: String)
        fun onShowError(msg: String)
    }
}