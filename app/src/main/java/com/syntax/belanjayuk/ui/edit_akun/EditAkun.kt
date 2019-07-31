package com.syntax.belanjayuk.ui.edit_akun

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.syntax.belanjayuk.R

class EditAkun : AppCompatActivity(), EditAkunContract.View {

    private lateinit var presenter: EditAkunPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_akun)

        initPresenter()
    }

    private fun initPresenter() {
        presenter = EditAkunPresenter()
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDettachView() {
        presenter.onDettach()
    }

}
