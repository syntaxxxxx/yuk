package com.syntax.belanjayuk.ui.order_details

import com.syntax.belanjayuk.base.BasePresenter

class OrderDetailsPresenter(var orderDetailView: OrderDetailsContract.View? = null) :
    BasePresenter<OrderDetailsContract.View> {

    override fun onAttach(view: OrderDetailsContract.View) {
        orderDetailView = view
    }

    override fun onDettach() {
        orderDetailView = null
    }
}