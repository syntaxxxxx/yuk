package com.syntax.belanjayuk.ui.login

import android.content.SharedPreferences
import com.syntax.belanjayuk.base.BasePresenter
import com.syntax.belanjayuk.data.model.login.ResponseLogin
import com.syntax.belanjayuk.data.repository.Injection
import com.syntax.belanjayuk.utils.MyConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(var loginView: LoginContract.View? = null) : BasePresenter<LoginContract.View>,
    LoginContract.Presenter {

    private val repository = Injection.provideRepository()

    override fun onAttach(view: LoginContract.View) {
        loginView = view
    }

    override fun onDettach() {
        loginView = null
    }

    override fun doLogin(email: String, password: String) {
        repository.login(email, password).enqueue(object : Callback<ResponseLogin> {

            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {

                if (response.isSuccessful) {

                    val isSuccess = response.body()?.isSuccess
                    val msg = response.body()?.message
                    val data = response.body()?.data

                    if (isSuccess == true) {
                        loginView?.onShowSuccess(data, msg!!)
                    } else {
                        loginView?.onShowError(msg!!)
                    }

                } else {
                    loginView?.onShowError(response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                loginView?.onShowError("Connection to ${t.message} failure")
            }
        })
    }

    /**
     * save state when user login to preference
     * @param sp
     * @param isRemember
     * */
    override fun isRememberMe(sp: SharedPreferences?, isRemember: Boolean) {
        sp?.edit()?.putBoolean(MyConstants.IS_LOGIN, isRemember)?.apply()
    }

    /**
     * save data user to preference
     * @param sp
     * @param id
     * @param email
     * @param firstName
     * @param lastName
     * */
    override fun saveToPreferences(
        sp: SharedPreferences?,
        id: String,
        email: String,
        firstName: String,
        lastName: String
    ) {
        val editor = sp?.edit()
        editor?.putString(MyConstants.IS_EMAIL, email)
        editor?.putString(MyConstants.IS_USER_ID, id)
        editor?.putString(MyConstants.IS_FIRST_NAME, firstName)
        editor?.putString(MyConstants.IS_LAST_NAME, lastName)
        editor?.apply()
    }
}