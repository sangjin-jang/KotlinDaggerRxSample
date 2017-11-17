package kr.co.mobidoo.kotlindaggerrxsample.model.source.main

import android.util.Log
import io.reactivex.Observable
import kr.co.mobidoo.kotlindaggerrxsample.model.UserResponse

class DataRepository(private val dataRemoteSource: DataRemoteSource) : DataSource{

    override fun getDataItems() : Observable<UserResponse> {
        Log.d("OnLoad", "come datarepository")
        return dataRemoteSource.getDataItems()
    }
}
