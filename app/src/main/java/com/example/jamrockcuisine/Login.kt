package com.example.jamrockcuisine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailField = findViewById<EditText>(R.id.emailInput);
        val passField = findViewById<EditText>(R.id.passwordInput);

        val loginButton = findViewById<Button>(R.id.loginButton2);
        loginButton.setOnClickListener {
            val email = emailField.text.toString();
            val pass = passField.text.toString();

            if ( email == "group1" && pass == "hello") {
                val intent = Intent(this, Home::class.java);
                startActivity(intent);
            }
        }
    }
}