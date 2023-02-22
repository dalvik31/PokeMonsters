package com.dalvik.pokemonsters.network.base

import com.dalvik.pokemonsters.BuildConfig
import com.dalvik.pokemonsters.network.repository.Repository
import com.dalvik.pokemonsters.network.services.PokeServices
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object GlobalModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class PokeRetrofit

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class PokeInterceptor

    @PokeInterceptor
    @Provides
    fun providesMarvelInterceptor(): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient.callTimeout(45, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(45, TimeUnit.SECONDS)
        okHttpClient.readTimeout(45, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(45, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClient.addInterceptor(interceptor)
        }
        return okHttpClient.build()
    }

    @PokeRetrofit
    @Singleton
    @Provides
    fun provideMarvelRetrofit(@PokeInterceptor httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/dalvik31/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(httpClient)
            .build()
    }


    //Services
    @Singleton
    @Provides
    fun provideMarvelServices(@PokeRetrofit retrofit: Retrofit): PokeServices {
        return retrofit.create(PokeServices::class.java)
    }

    //Data Source Interface
    @Provides
    fun provideMarvelRemoteDataSource(
        pokeServices: PokeServices
    ) =
        Repository(pokeServices)


}