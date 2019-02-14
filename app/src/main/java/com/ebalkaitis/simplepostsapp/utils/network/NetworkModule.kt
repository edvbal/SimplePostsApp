package com.ebalkaitis.simplepostsapp.utils.network

import com.ebalkaitis.simplepostsapp.BuildConfig
import com.ebalkaitis.simplepostsapp.utils.network.services.CommentsService
import com.ebalkaitis.simplepostsapp.utils.network.services.PostsService
import com.ebalkaitis.simplepostsapp.utils.network.services.UsersService
import com.ebalkaitis.simplepostsapp.utils.schedulers.Io
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class NetworkModule {
    @Module
    companion object {
        @JvmStatic @Singleton @Provides
        fun createRetrofit(client: OkHttpClient, @Io scheduler: Scheduler): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(scheduler))
                .build()
        }

        @JvmStatic @Provides
        fun provideOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(BODY))
                .build()
        }

        @JvmStatic @Provides
        fun providePostsService(retrofit: Retrofit): PostsService = retrofit.create(PostsService::class.java)

        @JvmStatic @Provides
        fun provideUsersService(retrofit: Retrofit): CommentsService = retrofit.create(CommentsService::class.java)

        @JvmStatic @Provides
        fun provideCommentsService(retrofit: Retrofit): UsersService = retrofit.create(UsersService::class.java)
    }
}
