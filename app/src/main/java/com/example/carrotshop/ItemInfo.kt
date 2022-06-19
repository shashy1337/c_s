package com.example.carrotshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.carrotshop.model.DataVegetable

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vegetable = arguments?.get("vegetable") as DataVegetable
        setStuff(view, vegetable)
    }


    fun setStuff(view : View, vegetable: DataVegetable){
        val vegetablePic = view.findViewById<ImageView>(R.id.itemDetailsPic)
        val vegetableDescription = view.findViewById<TextView>(R.id.details_description)
        val vegetableName = view.findViewById<Toolbar>(R.id.toolbar)

        vegetablePic.setImageResource(vegetable.vegetableicon)
        vegetableDescription.text = vegetable.vegetableDescription
        vegetableName.title = vegetable.vegetableName
    }
}