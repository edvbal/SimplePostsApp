package com.ebalkaitis.simplepostsapp.posts.fragment

import com.ebalkaitis.simplepostsapp.utils.scopes.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class PostsModule {

    @Module
    companion object {
        @FragmentScope @JvmStatic @Provides
        fun providePresenter(): PostsContract.Presenter = PostsPresenter()

        @FragmentScope @JvmStatic @Provides
        fun provideModel(): PostsContract.Model = PostsModel()
    }
}
