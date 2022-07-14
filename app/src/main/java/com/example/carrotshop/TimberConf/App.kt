package com.example.carrotshop.TimberConf

import android.app.Application
import com.example.carrotshop.Interfaces.ItemRecyclerView
import com.example.carrotshop.R
import com.example.carrotshop.model.AdvertiseInfoClass
import com.example.carrotshop.model.DataVegetable
import timber.log.Timber

class App : Application() {

    val itemList = listOf<ItemRecyclerView>(
        DataVegetable(R.drawable.kabachok, "Кобачки", false),
        DataVegetable(R.drawable.onion, "Лук", false),
        AdvertiseInfoClass("Скидка 30% на кукумберы!", "спешите купить"),
        DataVegetable(R.drawable.cucumber, "Огурцы", false),
        DataVegetable(R.drawable.tomato, "Томаты", false),
        AdvertiseInfoClass("Выходные с кабочками!", "спешите купить по лучшей цене!"),
        DataVegetable(R.drawable.svekla, "Свекла", false),
        AdvertiseInfoClass("СВЕКЛААААА", "УРАААААА"),
    )

    val favVegetable = mutableListOf<ItemRecyclerView>()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        instance = this
    }

    companion object {
        lateinit var instance : App
        private set
    }
}