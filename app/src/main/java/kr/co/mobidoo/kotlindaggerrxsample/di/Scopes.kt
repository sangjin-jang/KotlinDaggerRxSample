package kr.co.mobidoo.kotlindaggerrxsample.di

import javax.inject.Scope

/**
 * Created by DEV-A5 on 2017-11-14.
 */
@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class PerActivity

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class PerFragment
