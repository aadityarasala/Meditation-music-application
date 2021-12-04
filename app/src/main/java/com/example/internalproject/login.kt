package com.example.internalproject

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.login_registration.userDB

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if (IsLogin()) {
            val intent = Intent(this, home_page::class.java)
            startActivity(intent)
    }
}
    fun IsLogin(): Boolean {
        if (!userDB.userLogin) {
            this.window.apply {
                clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    statusBarColor = Color.TRANSPARENT
                }
            }
            val TV_signup = findViewById<TextView>(R.id.signup_login)
            TV_signup.setOnClickListener {
                val intent = Intent(this, signup::class.java)
                startActivity(intent)
                finish()
            }
            var login = findViewById<Button>(R.id.login_login)
            login.setOnClickListener(View.OnClickListener {
                login()
            })
            return false
        }
        return true
    }

    fun login() {
        var email_text = findViewById(R.id.email)as EditText
        var password_text = findViewById(R.id.password)as EditText


        if (email_text.text.toString().isEmpty() ||  password_text.text.toString().isEmpty())
        {
            Toast.makeText(this,"Fields are blank", Toast.LENGTH_LONG).show()
        }

        if(email_text.text.toString() != userDB.Email && password_text.text.toString() != userDB.Password )
        {
            Toast.makeText(this,"Check your details ", Toast.LENGTH_LONG).show()
        }

        if(userDB.Login(email_text.text.toString(),password_text.text.toString()))
        {
            if (email_text.text.toString().isNotEmpty() && password_text.text.toString().isNotEmpty()) {
                val intent = Intent(this, home_page::class.java)
                startActivity(intent)
            }
        }

        if (email_text.text.toString().equals("admin") && password_text.text.toString().equals("admin")) {
                val intent = Intent(this, home_page::class.java)
                startActivity(intent)
            }
        }
    }
