package com.ebalkaitis.simplepostsapp.post.details.mvp

import com.ebalkaitis.simplepostsapp.utils.scopes.FragmentScope
import dagger.Module
import dagger.Provides

@Module
abstract class PostDetailsModule {
    @Module
    companion object {
        @FragmentScope @JvmStatic @Provides
        fun providePresenter(): PostDetailsContract.Presenter = PostDetailsPresenter()
    }
}
