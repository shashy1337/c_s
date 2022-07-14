package com.example.carrotshop.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.carrotshop.Interfaces.ItemRecyclerView
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataVegetable
    (@DrawableRes val vegetableicon : Int, val vegetableName : String, var isFavourite : Boolean)
    : Parcelable, ItemRecyclerView
