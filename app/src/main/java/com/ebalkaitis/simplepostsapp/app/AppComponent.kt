package com.ebalkaitis.simplepostsapp.app

import com.ebalkaitis.simplepostsapp.app.SimplePostsApplication
import com.ebalkaitis.simplepostsapp.utils.network.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppContributorsModule::class,
        NetworkModule::class,
        AppModule::class
    ]
)

interface AppComponent : AndroidInjector<SimplePostsApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<SimplePostsApplication>()
}
