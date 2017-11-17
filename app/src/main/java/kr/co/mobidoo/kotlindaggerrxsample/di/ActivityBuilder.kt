package kr.co.mobidoo.kotlindaggerrxsample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.co.mobidoo.kotlindaggerrxsample.view.MainActivity
import kr.co.mobidoo.kotlindaggerrxsample.view.MainModule

/**
 * Created by DEV-A5 on 2017-11-14.
 */
@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity(): MainActivity
}