package com.syntax.belanjayuk.ui.register

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.syntax.belanjayuk.R
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity(), RegisterContract.View {

    private val presenter = RegisterPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_sign_up.setOnClickListener { presenter.onRegister() }
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDettachView() {
        presenter.onDettach()
    }

    override fun showFirstNameEror() {
    }

    override fun showLastNameError() {
    }

    override fun showEmailError() {
    }

    override fun showPasswordError() {
    }

    override fun showConfirmPasswordError() {
    }

    override fun showRegisterSuccess() {
    }

    override fun showRegisterError(message: String) {
    }

}
