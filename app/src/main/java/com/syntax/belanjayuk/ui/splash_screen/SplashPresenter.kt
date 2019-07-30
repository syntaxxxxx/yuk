package com.syntax.belanjayuk.ui.splash_screen

import android.content.SharedPreferences
import android.os.Handler
import com.syntax.belanjayuk.base.BasePresenter
import com.syntax.belanjayuk.utils.MyConstants

class SplashPresenter(var splashView: SplashContract.View? = null, private val preferences: SharedPreferences) :
    BasePresenter<SplashContract.View>,
    SplashContract.Presenter {

    override fun onAttach(view: SplashContract.View) {
        splashView = view
    }

    override fun onDettach() {
        splashView = null
    }

    override fun delaySplash(timer: Long) {
        Handler().postDelayed({
            if (isCheckSession()) {
                splashView?.onSuccess()
            } else {
                splashView?.intentToLogin()
            }
        }, timer)
    }

    override fun isCheckSession(): Boolean {
        return preferences.getBoolean(MyConstants.IS_LOGIN, false)
    }
}