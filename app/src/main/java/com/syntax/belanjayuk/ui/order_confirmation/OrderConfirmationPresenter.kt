package com.syntax.belanjayuk.ui.order_confirmation

import com.syntax.belanjayuk.base.BasePresenter

class OrderConfirmationPresenter(var orderConfView : OrderConfirmationContract.View? = null)
    :BasePresenter<OrderConfirmationContract.View>{

    override fun onAttach(view: OrderConfirmationContract.View) {
        orderConfView = view
    }

    override fun onDettach() {
        orderConfView = null
    }
}