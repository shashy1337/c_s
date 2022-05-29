package com.example.carrotshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.widget.Toast
import com.example.carrotshop.model.DataVegetable
import com.example.carrotshop.model.ItemRecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber

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

        Timber.d("OnCreate()_Method_Running...")

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
                    Toast.makeText(this, "Basket!", Toast.LENGTH_SHORT).show()
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

    fun launchItemInfo(item : DataVegetable){
        val bundle = Bundle()
        bundle.putParcelable("vegetable", item)
        val fragment = ItemInfo()
        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onStart() {
        super.onStart()
        Timber.d("OnStart()_Method_Running...")
    }

    override fun onResume(){
        super.onResume()
        Timber.d("OnResume()_Method_Running...")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("OnPause()_Method_Running...")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("OnStop()_Method_Running...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("OnDestroy()_Method_Running...")
    }

}