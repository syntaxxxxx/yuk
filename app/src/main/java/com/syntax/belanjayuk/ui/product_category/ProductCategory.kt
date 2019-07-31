package com.syntax.belanjayuk.ui.product_category

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.syntax.belanjayuk.R

class ProductCategory : AppCompatActivity(), ProductCatergoryContract.View {

    private lateinit var presenter: ProductCategoryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_category)

        initPresenter()
    }

    private fun initPresenter() {
        presenter = ProductCategoryPresenter()
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
