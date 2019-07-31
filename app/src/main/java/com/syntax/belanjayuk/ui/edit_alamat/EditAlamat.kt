package com.syntax.belanjayuk.ui.edit_alamat

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.syntax.belanjayuk.R

class EditAlamat : AppCompatActivity(), EditAlamatContract.View {

    private lateinit var presenter: EditAlamatPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_alamat)

        initPresenter()
    }

    private fun initPresenter() {
        presenter = EditAlamatPresenter()
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDettachView() {
        presenter.onDettach()
    }
}
