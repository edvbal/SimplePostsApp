package com.ebalkaitis.simplepostsapp.post.details.fragment

import com.ebalkaitis.simplepostsapp.post.details.mvp.PostDetailsContract
import com.ebalkaitis.simplepostsapp.post.details.mvp.PostDetailsPresenter
import com.ebalkaitis.simplepostsapp.utils.scopes.FragmentScope
import dagger.Module
import dagger.Provides

@Module
abstract class PostDetailsModule {
    @Module
    companion object {
        @FragmentScope @JvmStatic @Provides
        fun providePresenter(): PostDetailsContract.Presenter =
            PostDetailsPresenter()
    }
}
