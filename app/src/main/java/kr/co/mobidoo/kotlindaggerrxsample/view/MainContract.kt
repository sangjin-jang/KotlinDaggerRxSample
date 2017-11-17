package kr.co.mobidoo.kotlindaggerrxsample.view

/**
 * Created by DEV-A5 on 2017-11-14.
 */
interface MainContract {
    interface View {
        fun showToast(title : String)
    }

    interface Presenter {
        fun loadItem()
    }
}