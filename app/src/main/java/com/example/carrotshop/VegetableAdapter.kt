package com.example.carrotshop

import android.annotation.SuppressLint
import com.example.carrotshop.adapter.AdvertiseDelegateAdapter
import com.example.carrotshop.adapter.ProductDelegateAdapter
import com.example.carrotshop.model.DataVegetable
import com.example.carrotshop.model.ItemRecyclerView
import com.example.carrotshop.model.OnItemClickListener
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class VegetableAdapter(requireActivity: MainActivity) : ListDelegationAdapter<List<ItemRecyclerView>>() {

    init {
        delegatesManager.addDelegate(AdvertiseDelegateAdapter())
        delegatesManager.addDelegate(ProductDelegateAdapter(object : OnItemClickListener{
            override fun click(items: DataVegetable) {
                (requireActivity).launchItemInfo(items)
            }
        }))
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setItems(items: List<ItemRecyclerView>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}