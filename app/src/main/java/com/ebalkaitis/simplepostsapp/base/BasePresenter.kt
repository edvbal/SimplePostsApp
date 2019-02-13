package com.ebalkaitis.simplepostsapp.base

open class BasePresenter<T> : Presenter<T> {
    private var view: T? = null

    override fun takeView(view: T) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }

    fun hasView() = view != null

    fun onView(action: T.() -> Unit) {
        if (hasView()) {
            action.invoke(view!!)
        }
    }
}