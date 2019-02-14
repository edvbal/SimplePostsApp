package com.ebalkaitis.simplepostsapp.app

import com.ebalkaitis.simplepostsapp.posts.PostsActivity
import com.ebalkaitis.simplepostsapp.utils.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppContributorsModule {
    @ActivityScope
    @ContributesAndroidInjector()
    abstract fun contributePostsActivity(): PostsActivity
}
