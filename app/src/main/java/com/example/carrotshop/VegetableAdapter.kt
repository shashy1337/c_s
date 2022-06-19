package com.example.carrotshop

import android.annotation.SuppressLint
import com.example.carrotshop.adapter.AdvertiseDelegateAdapter
import com.example.carrotshop.adapter.ProductDelegateAdapter
import com.example.carrotshop.model.DataVegetable
import com.example.carrotshop.model.ItemRecyclerView
import com.example.carrotshop.model.OnClickVegetable
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class VegetableAdapter(requireActivity: MainActivity) : ListDelegationAdapter<List<ItemRecyclerView>>() {

    init {
        delegatesManager.addDelegate(AdvertiseDelegateAdapter())
        delegatesManager.addDelegate(ProductDelegateAdapter(object : OnClickVegetable {
            override fun click(vegetable: DataVegetable) {
               (requireActivity).startDetailsFragment(vegetable)
            }

        }))
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setItems(items: List<ItemRecyclerView>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}