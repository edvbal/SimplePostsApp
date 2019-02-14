package com.ebalkaitis.simplepostsapp.posts.fragment

import com.ebalkaitis.simplepostsapp.utils.network.services.PostsService
import com.ebalkaitis.simplepostsapp.utils.schedulers.Io
import com.ebalkaitis.simplepostsapp.utils.schedulers.Main
import com.ebalkaitis.simplepostsapp.utils.scopes.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
abstract class PostsModule {

    @Module
    companion object {
        @FragmentScope @JvmStatic @Provides
        fun providePresenter(
            model: PostsContract.Model,
            @Main scheduler: Scheduler
        ): PostsContract.Presenter = PostsPresenter(model, scheduler)

        @FragmentScope @JvmStatic @Provides
        fun provideModel(postsService: PostsService): PostsContract.Model = PostsModel(postsService)
    }
}
