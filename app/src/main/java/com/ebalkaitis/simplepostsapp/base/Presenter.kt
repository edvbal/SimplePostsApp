package com.ebalkaitis.simplepostsapp.base

interface Presenter<T> {
    fun takeView(view: T)
    fun dropView()
}
