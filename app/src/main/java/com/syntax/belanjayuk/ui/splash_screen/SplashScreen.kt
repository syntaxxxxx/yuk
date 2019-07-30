package com.syntax.belanjayuk.ui.splash_screen

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.syntax.belanjayuk.R
import com.syntax.belanjayuk.utils.MyConstants

class SplashScreen : AppCompatActivity(), SplashContract.View {

    override fun onSuccess() {

    }

    override fun intentToLogin() {
    }

    private lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val preference = getSharedPreferences(MyConstants.PREF_NAME, 0)
        initPresenter(preference)
        runDelaySplash()
    }

    private fun runDelaySplash() {
        presenter.delaySplash(1000)
    }

    private fun initPresenter(preference: SharedPreferences) {
        presenter = SplashPresenter(this, preference)
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDettachView() {
        presenter.onDettach()
    }

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDettachView()
    }
}
