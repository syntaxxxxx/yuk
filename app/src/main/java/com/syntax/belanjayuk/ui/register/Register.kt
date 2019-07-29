package com.syntax.belanjayuk.ui.register

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.syntax.belanjayuk.R
import com.syntax.belanjayuk.ui.login.Login
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class Register : AppCompatActivity(), RegisterContract.View {

    override fun isSuccess(msg: String) {
        startActivity<Login>()
        toast(msg)
    }

    override fun isEmptyField() {
        toast("tidak boleh kosong")
    }

    override fun isNotSamePassword() {
        toast("password harus sama")
    }

    override fun onShowError(msg: String) {
        toast(msg)
    }

    private val presenter = RegisterPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_sign_up.setOnClickListener {
            presenter.doRegister(
                edt_first_name.text.toString().trim(),
                edt_last_name.text.toString().trim(),
                edt_email.text.toString().trim(),
                edt_password.text.toString().trim(),
                edt_confirm_password.text.toString().trim()
            )
        }
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
