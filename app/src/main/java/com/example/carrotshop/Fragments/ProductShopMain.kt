package com.example.carrotshop.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils.loadLayoutAnimation
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotshop.Activitys.MainActivity
import com.example.carrotshop.R
import com.example.carrotshop.adapter.VegetableAdapter
import com.example.carrotshop.decorations.Offset
import com.example.carrotshop.model.AdvertiseInfoClass
import com.example.carrotshop.model.DataVegetable
import com.example.carrotshop.Interfaces.ItemRecyclerView
import com.example.carrotshop.TimberConf.App
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator

class ProductShopMain : Fragment() {


    val itemList = App.instance.itemList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterV = VegetableAdapter(requireActivity() as MainActivity)
        val rv = view.findViewById<RecyclerView>(R.id.vegetableRecyclerView)

        rv.apply {
            adapter = adapterV
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(Offset())
            itemAnimator = SlideInLeftAnimator()
            layoutAnimation = loadLayoutAnimation(context, R.anim.layoutvegetable)

        }

        adapterV.items = itemList

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_shop_main, container, false)
    }

}