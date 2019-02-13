package com.ebalkaitis.simplepostsapp.base.mvp

interface Presenter<T> {
    fun takeView(view: T)
    fun dropView()
}
