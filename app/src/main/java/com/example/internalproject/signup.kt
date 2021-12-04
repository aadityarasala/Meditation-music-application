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

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        var username = findViewById(R.id.user) as EditText
        var password = findViewById(R.id.password) as EditText
        if (IsLogin()) {
            val intent = Intent(this, home_page::class.java)
            startActivity(intent)
        }

        val TV_login = findViewById<TextView>(R.id.signup_signup)
        TV_login.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()
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
            var register = findViewById<Button>(R.id.login_signup)
            register.setOnClickListener {
                signup()
            }
            return false
        }
        return true
    }

    fun signup() {
        var username = findViewById(R.id.user) as EditText
        //var phoneno = findViewById(R.id.Phone)as EditText
        //var city = findViewById(R.id.City)as EditText
        var email = findViewById(R.id.email) as EditText
        var password = findViewById(R.id.password) as EditText
        //var configpass = findViewById(R.id.ConfiPass)as EditText
        if (username.text.toString().isEmpty() || email.text.toString()
                .isEmpty() || password.text.toString().isEmpty()
        ) {
            Toast.makeText(this, "Fields are blank", Toast.LENGTH_LONG).show()
        }
        if (username.text.toString().isNotEmpty() && email.text.toString()
                .isNotEmpty() && password.text.toString().isNotEmpty()
        ) {
            userDB.Name = username.text.toString()
            userDB.Password = password.text.toString()
            userDB.Email = email.text.toString()

            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun login(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}