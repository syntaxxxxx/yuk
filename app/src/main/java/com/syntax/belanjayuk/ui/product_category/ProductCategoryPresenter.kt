package com.syntax.belanjayuk.ui.product_category

import com.syntax.belanjayuk.base.BasePresenter

class ProductCategoryPresenter(var producCatView: ProductCatergoryContract.View? = null)
    :BasePresenter<ProductCatergoryContract.View>{

    override fun onAttach(view: ProductCatergoryContract.View) {
        producCatView = view
    }

    override fun onDettach() {
        producCatView = null
    }
}