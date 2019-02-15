package com.ebalkaitis.simplepostsapp.post

import com.ebalkaitis.simplepostsapp.post.fragment.PostsFragment
import com.ebalkaitis.simplepostsapp.post.fragment.PostsModule
import com.ebalkaitis.simplepostsapp.utils.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PostsActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [PostsModule::class])
    abstract fun contributePostsFragment(): PostsFragment
}
