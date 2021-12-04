package com.example.internalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class onboarding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)


        val btn_login = findViewById<Button>(R.id.login)
        btn_login.setOnClickListener{
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
        val TV_signup = findViewById<TextView>(R.id.signup)
        TV_signup.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }

    }
}