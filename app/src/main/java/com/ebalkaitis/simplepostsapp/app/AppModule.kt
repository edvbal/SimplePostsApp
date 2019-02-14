package com.ebalkaitis.simplepostsapp.app

import android.content.Context
import com.ebalkaitis.simplepostsapp.utils.schedulers.Io
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
abstract class AppModule {
    @Binds
    abstract fun bindApplicationContext(app: SimplePostsApplication): Context

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Io
        fun provideIoScheduler(): Scheduler = Schedulers.io()

        @JvmStatic
        @Provides
        @Io
        fun provideMainScheduler(): Scheduler = AndroidSchedulers.mainThread()
    }
}
