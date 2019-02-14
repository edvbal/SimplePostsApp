package com.ebalkaitis.simplepostsapp.utils.mvp

interface Presenter<T> {
    fun takeView(view: T)
    fun dropView()
}
