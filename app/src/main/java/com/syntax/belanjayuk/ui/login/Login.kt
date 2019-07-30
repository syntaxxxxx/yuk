package com.syntax.belanjayuk.ui.login

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.syntax.belanjayuk.R
import com.syntax.belanjayuk.data.model.login.Data
import com.syntax.belanjayuk.ui.register.Register
import com.syntax.belanjayuk.utils.SessionManager
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class Login : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginPresenter
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initPresenter()
        initSession()
        initEventListener()
    }

    private fun initEventListener() {
        btn_sign_in.setOnClickListener {
            presenter.doLogin(
                edt_email_login.text.toString().trim(),
                edt_password_login.text.toString().trim()
            )
        }
        tv_sign_up.setOnClickListener { startActivity<Register>() }
    }

    private fun initSession() {
        preferences = SessionManager(this).getPreference()
    }

    private fun initPresenter() {
        presenter = LoginPresenter()
    }

    override fun onShowSuccess(data: Data?, msg: String) {
        presenter.isRememberMe(preferences, cb_remember_me.isChecked)
        presenter.saveToPreferences(
            preferences,
            data?.id.toString(),
            data?.email.toString(),
            data?.firstName.toString(),
            data?.lastName.toString()
        )
    }

    override fun onShowError(msg: String) {
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
