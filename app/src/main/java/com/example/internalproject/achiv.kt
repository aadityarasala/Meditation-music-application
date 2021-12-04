package com.example.internalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class achiv : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_achiv)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_profile)
        bottomNavigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener)
    }
    val OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.STATS -> {
                    val intent = Intent(this, person::class.java)
                    startActivity(intent)
                }
                /*R.id.ACHIEVEMENTS -> {
                    val intent = Intent(this, achiv::class.java)
                    startActivity(intent)
                }*/
            }
            return@OnNavigationItemSelectedListener true
        }

}