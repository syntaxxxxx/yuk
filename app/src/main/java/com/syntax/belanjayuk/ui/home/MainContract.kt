package com.syntax.belanjayuk.ui.home

import com.syntax.belanjayuk.base.BaseView

interface MainContract {

    interface Presenter {
        fun getHomeProducts()
        fun getPromotionProducts()
        fun getCategories()
    }

    interface View : BaseView {

    }
}