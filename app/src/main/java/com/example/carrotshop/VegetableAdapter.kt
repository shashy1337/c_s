package com.example.carrotshop

import android.annotation.SuppressLint
import com.example.carrotshop.adapter.AdvertiseDelegateAdapter
import com.example.carrotshop.adapter.ProductDelegateAdapter
import com.example.carrotshop.model.ItemRecyclerView
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class VegetableAdapter() : ListDelegationAdapter<List<ItemRecyclerView>>() {

    init {
        delegatesManager.addDelegate(AdvertiseDelegateAdapter())
        delegatesManager.addDelegate(ProductDelegateAdapter())
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setItems(items: List<ItemRecyclerView>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}