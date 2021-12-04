package com.example.internalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class home_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val btn_VM = findViewById<Button>(R.id.vedicmusic_btn)
        btn_VM.setOnClickListener{
            val intent = Intent(this, vedic_music::class.java)
            startActivity(intent)
        }
        val btn_SM = findViewById<Button>(R.id.simplemusic_btn)
        btn_SM.setOnClickListener{
            val intent = Intent(this, sound::class.java)
            startActivity(intent)
        }
        var tool =  findViewById(R.id.top_menu) as ImageView
        tool.setOnClickListener{
            var intent = Intent(this, tools::class.java)
            startActivity(intent)
        }
        var prf =  findViewById(R.id.top_profile) as ImageView
        prf.setOnClickListener{
            var intent = Intent(this, person::class.java)
            startActivity(intent)
        }
        val bottomNavigation: BottomNavigationView = findViewById(R.id.nav_menu)
        bottomNavigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener)
    }
    val OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val intent = Intent(this, home_page::class.java)
                    startActivity(intent)
                }
                R.id.bottom_profile -> {
                    val intent = Intent(this, person::class.java)
                    startActivity(intent)
                }
                R.id.music -> {
                    val intent = Intent(this, soundqueue::class.java)
                    startActivity(intent)
                }
            }
            return@OnNavigationItemSelectedListener true

        }

}