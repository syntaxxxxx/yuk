package com.syntax.belanjayuk.ui.edit_akun

import com.syntax.belanjayuk.base.BasePresenter

class EditAkunPresenter(var editAkunView: EditAkunContract.View? = null) : BasePresenter<EditAkunContract.View> {

    override fun onAttach(view: EditAkunContract.View) {
        editAkunView = view
    }

    override fun onDettach() {
        editAkunView = null
    }
}