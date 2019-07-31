package com.syntax.belanjayuk.ui.edit_alamat

import com.syntax.belanjayuk.base.BasePresenter

class EditAlamatPresenter(var edtAlamatView: EditAlamatContract.View? = null)
    :BasePresenter<EditAlamatContract.View>{

    override fun onAttach(view: EditAlamatContract.View) {
        edtAlamatView = view
    }

    override fun onDettach() {
        edtAlamatView = null
    }
}