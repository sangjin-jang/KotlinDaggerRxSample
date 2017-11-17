package kr.co.mobidoo.kotlindaggerrxsample.di

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import kr.co.mobidoo.kotlindaggerrxsample.api.ApiService
import kr.co.mobidoo.kotlindaggerrxsample.model.source.main.DataRemoteSource
import kr.co.mobidoo.kotlindaggerrxsample.model.source.main.DataRepository
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by DEV-A5 on 2017-11-15.
 */
@Module
class NetModule {
    @Provides
    @Singleton
    fun provideHttpCache(application: Application): Cache = Cache(application.cacheDir, 10 * 1024 * 1024)

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setLenient()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(cache: Cache) : OkHttpClient{
        val builder = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(interceptor)
        return builder.cache(cache).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.androidhive.info")
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideDataRemoteSource(apiService: ApiService) : DataRemoteSource = DataRemoteSource(apiService)

    @Provides
    @Singleton
    fun provideDataRepository(dataRemoteSource: DataRemoteSource) : DataRepository = DataRepository(dataRemoteSource)
}