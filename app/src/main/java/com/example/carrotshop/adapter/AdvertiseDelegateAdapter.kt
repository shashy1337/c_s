package com.example.carrotshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotshop.R
import com.example.carrotshop.model.AdvertiseInfoClass
import com.example.carrotshop.model.DataVegetable
import com.example.carrotshop.model.ItemRecyclerView
import com.example.carrotshop.model.OnClickVegetable
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class AdvertiseDelegateAdapter :
    AbsListItemAdapterDelegate<AdvertiseInfoClass, ItemRecyclerView,
            AdvertiseDelegateAdapter.AdvHolder>() {

    class AdvHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.title_ad)
        val content = itemView.findViewById<TextView>(R.id.content_ad)

        fun onBind(advertise: AdvertiseInfoClass) {
            title.text = advertise.title
            content.text = advertise.content
        }

    }

    override fun isForViewType(
        item: ItemRecyclerView,
        items: MutableList<ItemRecyclerView>,
        position: Int
    ): Boolean {
        return item is AdvertiseInfoClass
    }

    override fun onCreateViewHolder(parent: ViewGroup): AdvHolder {
        return AdvHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.adv_item, parent, false))
    }

    override fun onBindViewHolder(
        item: AdvertiseInfoClass,
        holder: AdvHolder,
        payloads: MutableList<Any>
    ) {
        holder.onBind(item)
    }
}