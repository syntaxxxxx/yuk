package com.syntax.belanjayuk.ui.order_confirmation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.syntax.belanjayuk.R

class OrderConfirmation : AppCompatActivity(), OrderConfirmationContract.View {


    private lateinit var presenter: OrderConfirmationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_confirmation)

        initPresenter()
    }

    private fun initPresenter() {
        presenter = OrderConfirmationPresenter()
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDettachView() {
        presenter.onDettach()
    }

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDettachView()
    }
}
