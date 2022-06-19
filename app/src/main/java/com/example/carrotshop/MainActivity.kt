package com.example.carrotshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.carrotshop.model.DataVegetable
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTopBottomBar()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, ProductShopMain())
            .addToBackStack(null)
            .commit()

    }


    private fun initTopBottomBar(){
        val topBar = findViewById<MaterialToolbar>(R.id.TopToolbar)
        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_bar)
        topBar.apply {
            this.setNavigationOnClickListener {
                Toast.makeText(this@MainActivity, "Навигация", Toast.LENGTH_SHORT)
                    .show()
            }

            this.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.settings -> {
                        Toast.makeText(this@MainActivity, "Настройки", Toast.LENGTH_SHORT)
                            .show()
                        return@setOnMenuItemClickListener true
                    }

                    else -> return@setOnMenuItemClickListener false
                }
            }
        }

        bottomBar.setOnItemSelectedListener {
            when (it.itemId){
                R.id.products -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_placeholder, ProductShopMain())
                        .addToBackStack(null)
                        .commit()
                    return@setOnItemSelectedListener true
                }

                R.id.basket -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_placeholder, BasketFragment())
                        .addToBackStack(null)
                        .commit()
                    return@setOnItemSelectedListener true
                }

                R.id.rocketAnimationTest -> {

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_placeholder, RocketAnimFragment())
                        .addToBackStack(null)
                        .commit()

                    return@setOnItemSelectedListener true
                }

                else -> return@setOnItemSelectedListener false
            }
        }
    }

    fun startDetailsFragment(vegetable: DataVegetable){
        val bundle = Bundle()
        bundle.putParcelable("vegetable", vegetable)
        val fragmentInfo = ItemInfo()
        fragmentInfo.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragmentInfo)
            .addToBackStack(null)
            .commit()
    }
}