package com.example.carrotshop.Fragments

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.carrotshop.R
import com.example.carrotshop.TimberConf.App
import com.example.carrotshop.model.DataVegetable
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
        initFabButtons(view, vegetable)
    }

    fun onBind(view: View, vegetable : DataVegetable){
        val vegetableIcon = view.findViewById<ImageView>(R.id.vegetable_icon_item)
        val vegetableDescription = view.findViewById<TextView>(R.id.details_description)
        vegetableIcon.setImageResource(vegetable.vegetableicon)
        vegetableDescription.text = vegetable.vegetableName
    }

    fun initFabButtons(view: View, vegetable : DataVegetable){
        val fabFavourite = view.findViewById<FloatingActionButton>(R.id.fabFav)
        val fabShare = view.findViewById<FloatingActionButton>(R.id.fabShare)
        fabFavourite.setOnClickListener {
            if(!vegetable.isFavourite) {
                fabFavourite.setImageResource(R.drawable.ic_baseline_favorite_24)
                vegetable.isFavourite = true
                App.instance.favVegetable.add(vegetable)
            } else{
                fabFavourite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                vegetable.isFavourite = false
                App.instance.favVegetable.remove(vegetable)
            }
        }
        fabShare.setOnClickListener{
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Я купил ${vegetable.vegetableName} в этом крутом приложении!")
                type = "text/plain"
            }
            try {
                startActivity(intent)
            } catch (e : ActivityNotFoundException){
                e.printStackTrace()
            }

        }
    }
}