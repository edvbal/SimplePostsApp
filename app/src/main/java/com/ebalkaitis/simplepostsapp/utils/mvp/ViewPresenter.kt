package com.ebalkaitis.simplepostsapp.utils.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class ViewPresenter<T> : BasePresenter<T> {
    private val disposables = CompositeDisposable()

    private var view: T? = null

    override fun takeView(view: T) {
        this.view = view
    }

    override fun dropView() {
        disposables.dispose()
        view = null
    }

    fun launchJob(job: () -> Disposable) {
        disposables.add(job())
    }

    fun hasView() = view != null

    fun onView(action: T.() -> Unit) {
        if (hasView()) {
            action.invoke(view!!)
        }
    }
}
