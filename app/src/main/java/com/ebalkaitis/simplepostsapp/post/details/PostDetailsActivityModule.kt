package com.ebalkaitis.simplepostsapp.post.details

import com.ebalkaitis.simplepostsapp.post.details.fragment.PostDetailsFragment
import com.ebalkaitis.simplepostsapp.post.details.fragment.PostDetailsModule
import com.ebalkaitis.simplepostsapp.utils.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PostDetailsActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [PostDetailsModule::class])
    abstract fun contributePostsFragment(): PostDetailsFragment
}
