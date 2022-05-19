package com.example.carrotshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotshop.R
import com.example.carrotshop.model.DataVegetable
import com.example.carrotshop.model.ItemRecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ProductDelegateAdapter :
    AbsListItemAdapterDelegate<DataVegetable, ItemRecyclerView, ProductDelegateAdapter.VegetableHolder>() {

    class VegetableHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val vegetableIcon = itemView.findViewById<ImageView>(R.id.vegetable_icon)
        val vegetableDescription = itemView.findViewById<TextView>(R.id.vegetable_name)

        fun onBind(vegetable: DataVegetable){
            vegetableIcon.setImageResource(vegetable.vegetableicon)
            vegetableDescription.text = vegetable.vegetableName
        }


    }

    override fun isForViewType(
        item: ItemRecyclerView,
        items: MutableList<ItemRecyclerView>,
        position: Int
    ): Boolean {
        return item is DataVegetable
    }

    override fun onCreateViewHolder(parent: ViewGroup): VegetableHolder {
        return VegetableHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.vegetable_holder, parent, false))
    }

    override fun onBindViewHolder(
        item: DataVegetable,
        holder: VegetableHolder,
        payloads: MutableList<Any>
    ) {
        holder.onBind(item)
    }
}