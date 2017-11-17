package kr.co.mobidoo.kotlindaggerrxsample.view.adapter

import kr.co.mobidoo.kotlindaggerrxsample.model.Data

/**
 * Created by DEV-A5 on 2017-11-14.
 */
interface RecyclerContract {
    interface View{
        fun notifyAdapter()
    }

    interface Model {
        fun addItem(list : ArrayList<Data>)
        fun clearItem()
    }
}