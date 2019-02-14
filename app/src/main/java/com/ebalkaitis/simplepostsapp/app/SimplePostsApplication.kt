package com.ebalkaitis.simplepostsapp.app

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class SimplePostsApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}
