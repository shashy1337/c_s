package com.example.carrotshop.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotshop.Activitys.MainActivity
import com.example.carrotshop.R
import com.example.carrotshop.TimberConf.App
import com.example.carrotshop.adapter.FavOnlyAdapter
import com.example.carrotshop.decorations.Offset
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator


class FavouritesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerFav(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }


    fun initRecyclerFav(view: View){
        val rv = view.findViewById<RecyclerView>(R.id.favRV)
        val adapterFav = FavOnlyAdapter(requireActivity() as MainActivity)
        rv.apply {
            adapter = adapterFav
            addItemDecoration(Offset())
            itemAnimator = SlideInLeftAnimator()
            layoutManager = LinearLayoutManager(requireContext())
            layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.layoutvegetable)
        }
        adapterFav.items = App.instance.favVegetable
    }
}