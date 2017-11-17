package kr.co.mobidoo.kotlindaggerrxsample.view

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.co.mobidoo.kotlindaggerrxsample.model.source.main.DataRepository
import kr.co.mobidoo.kotlindaggerrxsample.view.adapter.RecyclerContract
import javax.inject.Inject

/**
 * Created by DEV-A5 on 2017-11-14.
 */
class MainPresenter@Inject constructor(
        val view : MainContract.View, private val dataRepository: DataRepository, val adapterView: RecyclerContract.View, val adapterModel: RecyclerContract.Model) : MainContract.Presenter{
    override fun loadItem() {
        Log.d("OnLoad", "come presenter")
        dataRepository.getDataItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    result -> adapterModel.addItem(result.contacts)
                              adapterView.notifyAdapter()
                }, { error -> view.showToast(error.toString())})
    }
}