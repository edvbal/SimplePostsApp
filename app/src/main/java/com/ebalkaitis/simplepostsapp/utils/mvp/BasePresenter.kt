package com.ebalkaitis.simplepostsapp.utils.mvp

interface BasePresenter<T> {
    fun takeView(view: T)
    fun dropView()
}
