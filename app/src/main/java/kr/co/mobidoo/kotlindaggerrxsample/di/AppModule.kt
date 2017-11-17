package kr.co.mobidoo.kotlindaggerrxsample.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by DEV-A5 on 2017-11-14.
 */
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideApplication(application: Application) : Context = application

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)
}