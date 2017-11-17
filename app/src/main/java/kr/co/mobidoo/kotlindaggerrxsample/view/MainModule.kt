package kr.co.mobidoo.kotlindaggerrxsample.view

import dagger.Module
import dagger.Provides
import kr.co.mobidoo.kotlindaggerrxsample.di.PerActivity
import kr.co.mobidoo.kotlindaggerrxsample.model.source.main.DataRepository
import kr.co.mobidoo.kotlindaggerrxsample.view.adapter.RecyclerVIewAdapter

/**
 * Created by DEV-A5 on 2017-11-14.
 */
@Module
class MainModule {
    @Provides
    @PerActivity
    fun proivdeMainContractView(mainActivity: MainActivity) : MainContract.View = mainActivity

    @Provides
    @PerActivity
    fun provideRecyclerViewAdpater() : RecyclerVIewAdapter = RecyclerVIewAdapter()

    @Provides
    @PerActivity
    fun provideMainContractPresenter(view : MainContract.View, dataRepository: DataRepository, adapterView: RecyclerVIewAdapter, adapterModel: RecyclerVIewAdapter) : MainContract.Presenter = MainPresenter(view, dataRepository, adapterView, adapterModel)
}