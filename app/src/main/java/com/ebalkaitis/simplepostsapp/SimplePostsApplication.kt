package com.ebalkaitis.simplepostsapp

import com.ebalkaitis.simplepostsapp.base.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class SimplePostsApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}
