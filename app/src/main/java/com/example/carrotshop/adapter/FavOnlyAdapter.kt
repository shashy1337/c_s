package com.example.carrotshop.adapter

import com.example.carrotshop.Activitys.MainActivity
import com.example.carrotshop.Interfaces.ItemRecyclerView
import com.example.carrotshop.Interfaces.OnItemClickListener
import com.example.carrotshop.model.DataVegetable
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class VegetableOnlyAdapter(requireActivity : MainActivity) : ListDelegationAdapter<List<ItemRecyclerView>>() {

    init {
        delegatesManager.addDelegate(ProductDelegateAdapter(object : OnItemClickListener {
            override fun click(items: DataVegetable) {
                (requireActivity).launchItemInfo(items)
            }
        }))
    }

    override fun setItems(items: List<ItemRecyclerView>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}