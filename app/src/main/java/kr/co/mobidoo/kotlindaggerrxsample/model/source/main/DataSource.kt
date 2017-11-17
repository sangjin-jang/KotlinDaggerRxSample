package kr.co.mobidoo.kotlindaggerrxsample.model.source.main

import io.reactivex.Observable
import kr.co.mobidoo.kotlindaggerrxsample.model.UserResponse

/**
 * Created by DEV-A5 on 2017-11-15.
 */
interface DataSource {
    interface LoadDataCallback{
        fun onDataLoaded(userResponse: UserResponse?)
        fun onDataAvailable()
        fun onLoadFail(code : Int, message : String)
    }

    fun getDataItems():Observable<UserResponse>
}