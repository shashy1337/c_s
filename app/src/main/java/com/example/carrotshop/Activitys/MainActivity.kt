package com.example.carrotshop.Activitys

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.carrotshop.Fragments.FavouritesFragment
import com.example.carrotshop.Fragments.ItemInfo
import com.example.carrotshop.Fragments.ProductShopMain
import com.example.carrotshop.R
import com.example.carrotshop.Fragments.RocketAnimFragment
import com.example.carrotshop.databinding.ActivityMainBinding
import com.example.carrotshop.model.DataVegetable
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import timber.log.Timber
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = this.findNavController(R.id.myNavHostController)
        initTopBottomBar()
        Timber.d("OnCreate()_Method_Running...")
    }


    private fun initTopBottomBar(){
        setSupportActionBar(binding.TopToolbar)
        NavigationUI.setupActionBarWithNavController(this,navController)
        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.app_bar_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return NavigationUI.onNavDestinationSelected(menuItem,navController)
            }
        })

        NavigationUI.setupWithNavController(binding.bottomBar, navController)
    }



    fun launchItemInfo(item : DataVegetable){
        val bundle = Bundle()
        bundle.putParcelable("vegetable", item)
        navController.navigate(R.id.action_productShopMain_to_itemInfo, bundle)
    }

    fun launchItemFav(item : DataVegetable){
        val bundle = Bundle()
        bundle.putParcelable("vegetable", item)
        navController.navigate(R.id.action_favouritesFragment_to_itemInfo, bundle)
    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
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