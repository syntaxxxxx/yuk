package com.syntax.belanjayuk.ui.splash_screen

import com.syntax.belanjayuk.base.BaseView

interface SplashContract {

    interface Presenter {
        fun delaySplash(timer : Long)
        fun isCheckSession() : Boolean
    }

    interface View :BaseView {
        fun onSuccess()
        fun intentToLogin()
    }
}