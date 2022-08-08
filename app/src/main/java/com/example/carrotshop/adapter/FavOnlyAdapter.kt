package com.example.carrotshop.adapter

import android.annotation.SuppressLint
import com.example.carrotshop.Activitys.MainActivity
import com.example.carrotshop.Interfaces.ItemRecyclerView
import com.example.carrotshop.Interfaces.OnItemClickListener
import com.example.carrotshop.model.DataVegetable
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class FavOnlyAdapter(requireActivity : MainActivity) : ListDelegationAdapter<List<ItemRecyclerView>>() {

    init {
        delegatesManager.addDelegate(ProductDelegateAdapter(object : OnItemClickListener {
            override fun click(items: DataVegetable) {
                (requireActivity).launchItemFav(items)
            }
        }))
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setItems(items: List<ItemRecyclerView>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}