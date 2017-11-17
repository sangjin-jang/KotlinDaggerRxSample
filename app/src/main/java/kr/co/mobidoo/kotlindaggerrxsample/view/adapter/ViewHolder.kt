package kr.co.mobidoo.kotlindaggerrxsample.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_main.view.*
import kr.co.mobidoo.kotlindaggerrxsample.model.Data

/**
 * Created by DEV-A5 on 2017-11-14.
 */
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item : Data){
        itemView.number.text = item.id
        itemView.name.text = item.name
    }
}