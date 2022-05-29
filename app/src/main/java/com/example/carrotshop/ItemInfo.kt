package com.example.carrotshop

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import com.example.carrotshop.model.DataVegetable
import com.google.android.material.appbar.CollapsingToolbarLayout

class ItemInfo : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_info, container, false)
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        val vegetable = arguments?.get("vegetable") as DataVegetable
        toolbar.setCollapsedTitleTextColor(Color.WHITE)
        toolbar.setExpandedTitleColor(Color.WHITE)
        onBind(view, vegetable)
    }

    fun onBind(view: View, vegetable : DataVegetable){
        val vegetableIcon = view.findViewById<ImageView>(R.id.vegetable_icon_item)
        val vegetableDescription = view.findViewById<TextView>(R.id.details_description)
        vegetableIcon.setImageResource(vegetable.vegetableicon)
        vegetableDescription.text = vegetable.vegetableName
    }
}