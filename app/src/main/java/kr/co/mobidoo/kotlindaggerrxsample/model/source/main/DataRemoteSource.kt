package kr.co.mobidoo.kotlindaggerrxsample.model.source.main

import android.util.Log
import io.reactivex.Observable
import kr.co.mobidoo.kotlindaggerrxsample.api.ApiService
import kr.co.mobidoo.kotlindaggerrxsample.model.UserResponse

class DataRemoteSource(private val apiService: ApiService) : DataSource{
    override fun getDataItems() : Observable<UserResponse> {
        Log.d("OnLoad", "come remotesource")

        return apiService.getList()
        /*apiService.getList().enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>?, response: Response<UserResponse>?) {
                Log.d("OnLoad", "msg="+response.toString())
                loadDataCallback.onDataLoaded(response!!.body() as UserResponse)
            }

            override fun onFailure(call: Call<UserResponse>?, t: Throwable?) {
                Log.d("OnLoad", "t="+t.toString())
            }
        })*/
    }
}
