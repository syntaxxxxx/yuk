package com.syntax.belanjayuk.ui.akun

import com.syntax.belanjayuk.base.BasePresenter

class AkunPresenter(var akunView : AkunContract.View? = null)
    :BasePresenter<AkunContract.View>{

    override fun onAttach(view: AkunContract.View) {
        akunView = view
    }

    override fun onDettach() {
        akunView = null
    }
}