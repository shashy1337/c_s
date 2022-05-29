package com.example.carrotshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils.loadLayoutAnimation
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotshop.decorations.Offset
import com.example.carrotshop.model.AdvertiseInfoClass
import com.example.carrotshop.model.DataVegetable
import com.example.carrotshop.model.ItemRecyclerView
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator

class ProductShopMain : Fragment() {


    val itemList = listOf<ItemRecyclerView>(
        DataVegetable(R.drawable.kabachok, "Кобачки"),
        DataVegetable(R.drawable.onion, "Лук"),
        AdvertiseInfoClass("Скидка 30% на кукумберы!", "спешите купить"),
        DataVegetable(R.drawable.cucumber, "Огурцы"),
        DataVegetable(R.drawable.tomato, "Томаты"),
        AdvertiseInfoClass("Выходные с кабочками!", "спешите купить по лучшей цене!"),
        DataVegetable(R.drawable.svekla, "Свекла"),
        AdvertiseInfoClass("СВЕКЛААААА", "УРАААААА"),
    )

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