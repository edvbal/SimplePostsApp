package com.ebalkaitis.simplepostsapp.app

import com.ebalkaitis.simplepostsapp.post.PostsActivity
import com.ebalkaitis.simplepostsapp.post.PostsActivityModule
import com.ebalkaitis.simplepostsapp.utils.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppContributorsModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [PostsActivityModule::class])
    abstract fun contributePostsActivity(): PostsActivity
}
