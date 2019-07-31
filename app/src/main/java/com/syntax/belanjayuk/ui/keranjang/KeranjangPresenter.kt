package com.syntax.belanjayuk.ui.keranjang

import com.syntax.belanjayuk.base.BasePresenter

class KeranjangPresenter(var keranjangView : KeranjangContract.View? = null)
    :BasePresenter<KeranjangContract.View>{

    override fun onAttach(view: KeranjangContract.View) {
        keranjangView = view
    }

    override fun onDettach() {
        keranjangView = null
    }
}