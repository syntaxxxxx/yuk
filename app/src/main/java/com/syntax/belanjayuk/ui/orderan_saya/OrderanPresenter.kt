package com.syntax.belanjayuk.ui.orderan_saya

import com.syntax.belanjayuk.base.BasePresenter

class OrderanPresenter(var orderanView : OrderanContract.View? = null)
    :BasePresenter<OrderanContract.View>{

    override fun onAttach(view: OrderanContract.View) {
        orderanView = view
    }

    override fun onDettach() {
        orderanView = null
    }
}