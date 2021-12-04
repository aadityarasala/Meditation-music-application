package com.example.internalproject

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class sound : AppCompatActivity() {
    lateinit var runnable: Runnable
    private var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound)

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
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.soundmusic)

        var btnplay = findViewById(R.id.play)as ImageView
        //var btnpause = findViewById(R.id.pause)as ImageView

        val seekbar = findViewById<SeekBar>(R.id.seekbar)
        //seekbar.progress = 0
        seekbar.max = mediaPlayer.duration

        btnplay.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                btnplay.setImageResource(R.drawable.pause)
            }
            else{
                mediaPlayer.pause()
                btnplay.setImageResource(R.drawable.play)
            }
        }


        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                if (changed){
                    mediaPlayer.seekTo(pos)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        runnable =Runnable{
            seekbar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)

        mediaPlayer.setOnCompletionListener {
            btnplay.setImageResource(R.drawable.play)
            seekbar.progress=0
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

        /*val queue = findViewById(R.id.music) as ImagesView
        queue.setOnClickListener {
            val intent = Intent(this, soundqueue::class.java)
            startActivity(intent)
        }
        val home = findViewById(R.id.home) as ImageView
        home.setOnClickListener {
            val intent = Intent(this, home_page::class.java)
            startActivity(intent)
        }*/
