package kr.co.mobidoo.kotlindaggerrxsample.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kr.co.mobidoo.kotlindaggerrxsample.R
import kr.co.mobidoo.kotlindaggerrxsample.model.Data

/**
 * Created by DEV-A5 on 2017-11-14.
 */
class RecyclerVIewAdapter : RecyclerView.Adapter<ViewHolder>(), RecyclerContract.View, RecyclerContract.Model {
    private var list : ArrayList<Data>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list!![position])
    }

    override fun getItemCount(): Int = if(list == null) 0 else list!!.size

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun addItem(list: ArrayList<Data>) {
        this.list=list
    }

    override fun clearItem() {
        list?.clear()
    }
}