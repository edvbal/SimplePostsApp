package com.ebalkaitis.simplepostsapp.posts

import com.ebalkaitis.simplepostsapp.posts.fragment.PostsFragment
import com.ebalkaitis.simplepostsapp.posts.fragment.PostsModule
import com.ebalkaitis.simplepostsapp.utils.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PostsActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [PostsModule::class])
    abstract fun contributePostsFragment(): PostsFragment
}
