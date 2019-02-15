package com.ebalkaitis.simplepostsapp.post.list

import com.ebalkaitis.simplepostsapp.post.list.fragment.PostsFragment
import com.ebalkaitis.simplepostsapp.post.list.fragment.PostsModule
import com.ebalkaitis.simplepostsapp.utils.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PostsActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [PostsModule::class])
    abstract fun contributePostsFragment(): PostsFragment
}
