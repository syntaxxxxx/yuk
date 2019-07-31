package com.syntax.belanjayuk.ui.home

import com.syntax.belanjayuk.base.BasePresenter

class MainPresenter(var mainView: MainContract.View? = null)
    : BasePresenter<MainContract.View>, MainContract.Presenter {

    override fun onAttach(view: MainContract.View) {
        mainView = view
    }

    override fun onDettach() {
        mainView = null
    }

    override fun getHomeProducts() {

    }

    override fun getPromotionProducts() {
    }

    override fun getCategories() {
    }

}