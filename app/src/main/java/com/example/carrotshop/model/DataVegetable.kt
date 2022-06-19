package com.example.carrotshop.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.carrotshop.model.ItemRecyclerView
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataVegetable(@DrawableRes val vegetableicon : Int, val vegetableName : String, val vegetableDescription: String)
    : Parcelable, ItemRecyclerView
