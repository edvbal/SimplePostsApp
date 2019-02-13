package com.ebalkaitis.simplepostsapp.base.dagger

import com.ebalkaitis.simplepostsapp.SimplePostsApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class
    ]
)

interface AppComponent : AndroidInjector<SimplePostsApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<SimplePostsApplication>()
}
