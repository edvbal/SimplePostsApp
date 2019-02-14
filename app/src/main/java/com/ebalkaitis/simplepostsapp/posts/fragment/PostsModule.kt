package com.ebalkaitis.simplepostsapp.posts.fragment

import com.ebalkaitis.simplepostsapp.posts.fragment.list.PostClickListener
import com.ebalkaitis.simplepostsapp.posts.fragment.list.PostsAdapter
import com.ebalkaitis.simplepostsapp.posts.fragment.list.PostsViewHolderFactory
import com.ebalkaitis.simplepostsapp.posts.fragment.mvp.PostsContract
import com.ebalkaitis.simplepostsapp.posts.fragment.mvp.PostsModel
import com.ebalkaitis.simplepostsapp.posts.fragment.mvp.PostsPresenter
import com.ebalkaitis.simplepostsapp.utils.network.services.PostsService
import com.ebalkaitis.simplepostsapp.utils.schedulers.Main
import com.ebalkaitis.simplepostsapp.utils.scopes.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
abstract class PostsModule {
    @Binds
    abstract fun bindArticleClickListener(fragment: PostsFragment): PostClickListener

    @Module
    companion object {
        @FragmentScope @JvmStatic @Provides
        fun providePresenter(
            model: PostsContract.Model,
            @Main scheduler: Scheduler
        ): PostsContract.Presenter = PostsPresenter(model, scheduler)

        @FragmentScope @JvmStatic @Provides
        fun provideModel(postsService: PostsService): PostsContract.Model =
            PostsModel(postsService)

        @JvmStatic @Provides
        fun provideViewHolderFactory(listener: PostClickListener): PostsViewHolderFactory {
            return PostsViewHolderFactory(listener)
        }

        @JvmStatic @Provides
        fun provideAdapter(factory: PostsViewHolderFactory): PostsAdapter {
            return PostsAdapter(factory)
        }
    }
}
