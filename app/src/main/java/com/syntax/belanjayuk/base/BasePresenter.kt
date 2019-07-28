package com.syntax.belanjayuk.base

interface BasePresenter<in T : BaseView> {
    fun onAttach(view: T)
    fun onDettach()
}