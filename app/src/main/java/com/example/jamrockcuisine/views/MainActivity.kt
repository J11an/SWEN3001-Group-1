package com.example.jamrockcuisine.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.jamrockcuisine.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.loginButton);
        loginButton.setOnClickListener {
            switchView("Login")
        }

        val registerButton = findViewById<Button>(R.id.registerButton);
        registerButton.setOnClickListener {
            switchView("Register")
        }

    }

    fun switchView(viewName: String){

        when (viewName) {
            "Login" ->{
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
            }
            "Register" ->{
                val intent = Intent(this, Register::class.java)
                startActivity(intent)
            }
        }
    }
}