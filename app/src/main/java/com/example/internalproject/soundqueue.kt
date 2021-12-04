package com.example.internalproject

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import com.google.android.material.bottomnavigation.BottomNavigationView

class soundqueue : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soundqueue)

        val s1 = findViewById<Button>(R.id.music_btn)
        s1.setOnClickListener {
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
        /*
        var m1 = findViewById<LinearLayout>(R.id.linear1)
        m1.setOnClickListener {
            val intent = Intent(this, sound::class.java)
            startActivity(intent)
        }
        var m2 = findViewById<LinearLayout>(R.id.linear2)
        m2.setOnClickListener {
            val intent = Intent(this, sound_2::class.java)
            startActivity(intent)
        }
        var m3 = findViewById<LinearLayout>(R.id.linear3)
        m3.setOnClickListener {
            val intent = Intent(this, sound_3::class.java)
            startActivity(intent)
        }*/
        /*val queue = findViewById(R.id.soundqueue) as ImageView
        queue.setOnClickListener {
            val intent = Intent(this, soundqueue::class.java)
            startActivity(intent)
        }
        val home = findViewById(R.id.home) as ImageView
        home.setOnClickListener {
            val intent = Intent(this, home_page::class.java)
            startActivity(intent)
        }*/
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