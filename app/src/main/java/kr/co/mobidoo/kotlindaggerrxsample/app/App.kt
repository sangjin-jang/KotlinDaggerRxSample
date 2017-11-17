package kr.co.mobidoo.kotlindaggerrxsample.app

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import kr.co.mobidoo.kotlindaggerrxsample.di.DaggerAppComponent
import javax.inject.Inject

/**
 * Created by DEV-A5 on 2017-11-14.
 */
class App : Application(), HasActivityInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .application(this)
                .build().inject(this)
    }

    override fun activityInjector() : DispatchingAndroidInjector<Activity> = activityDispatchingAndroidInjector
}