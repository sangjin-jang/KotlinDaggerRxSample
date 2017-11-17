package kr.co.mobidoo.kotlindaggerrxsample.api

import io.reactivex.Observable
import kr.co.mobidoo.kotlindaggerrxsample.model.UserResponse
import retrofit2.http.GET

/**
 * Created by DEV-A5 on 2017-11-14.
 */
interface ApiService {
    @GET("/contacts")
    fun getList() : Observable<UserResponse>
}