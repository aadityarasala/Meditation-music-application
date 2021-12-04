package com.example.internalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView

class person : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        var tool =  findViewById(R.id.top_menu) as ImageView
        tool.setOnClickListener{
            var intent = Intent(this, tools::class.java)
            startActivity(intent)
        }
        //val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Handle the back button event
        //}


        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_profile)
        bottomNavigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener)
    }
    val OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                /*R.id.STATS -> {
                    val intent = Intent(this, profile::class.java)
                    startActivity(intent)
                }*/
                R.id.ACHIEVEMENTS -> {
                    val intent = Intent(this, achiv::class.java)
                    startActivity(intent)
                }
            }
            return@OnNavigationItemSelectedListener true
        }

}