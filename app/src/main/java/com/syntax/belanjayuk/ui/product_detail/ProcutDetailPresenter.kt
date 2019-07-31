package com.syntax.belanjayuk.ui.product_detail

import com.syntax.belanjayuk.base.BasePresenter

class ProcutDetailPresenter(var productDetailView: ProductDetailContract.View? = null)
    : BasePresenter<ProductDetailContract.View>{

    override fun onAttach(view: ProductDetailContract.View) {
        productDetailView = view
    }

    override fun onDettach() {
        productDetailView = null
    }
}