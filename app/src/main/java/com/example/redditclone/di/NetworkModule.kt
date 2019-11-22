package com.example.redditclone.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {
    @Provides
    @Singleton
    @JvmStatic
    fun interceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().also { it.level = HttpLoggingInterceptor.Level.BODY }


    @Provides
    @Singleton
    @JvmStatic
    fun client(interceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .connectTimeout(100, TimeUnit.SECONDS)
        .writeTimeout(100, TimeUnit.SECONDS)
        .readTimeout(300, TimeUnit.SECONDS)
        .build()

}