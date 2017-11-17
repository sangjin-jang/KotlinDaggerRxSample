package kr.co.mobidoo.kotlindaggerrxsample.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import kr.co.mobidoo.kotlindaggerrxsample.app.App
import javax.inject.Singleton


/**
 * Created by DEV-A5 on 2017-11-14.
 */
@Singleton
@Component(modules=arrayOf(AppModule::class, NetModule::class, AndroidSupportInjectionModule::class, ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject (app:App)
}