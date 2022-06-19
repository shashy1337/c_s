package com.example.carrotshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotshop.R
import com.example.carrotshop.model.DataVegetable
import com.example.carrotshop.model.ItemRecyclerView
import com.example.carrotshop.model.OnClickVegetable
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ProductDelegateAdapter(private val onClickVegetable: OnClickVegetable) :
    AbsListItemAdapterDelegate<DataVegetable, ItemRecyclerView, ProductDelegateAdapter.VegetableHolder>() {

    class VegetableHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val vegetableIcon = itemView.findViewById<ImageView>(R.id.vegetable_icon)
        val vegetableName = itemView.findViewById<TextView>(R.id.vegetable_name)
        val vegetableDescription = itemView.findViewById<TextView>(R.id.details_description)

        fun onBind(vegetable: DataVegetable){

            vegetableIcon.setImageResource(vegetable.vegetableicon)
            vegetableName.text = vegetable.vegetableName

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
        holder.itemView.findViewById<CardView>(R.id.item_container).setOnClickListener {
            onClickVegetable.click(item)
        }
    }
}