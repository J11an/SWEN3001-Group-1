package com.example.jamrockcuisine.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.jamrockcuisine.DBHandler
import com.example.jamrockcuisine.R

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //println(R.drawable.ackee_and_saltfish)
        val dbHandler = DBHandler(this)
        dbHandler.onUpgrade(dbHandler.writableDatabase,dbHandler.readableDatabase.version,dbHandler.writableDatabase.version)
        val registerButton = findViewById<Button>(R.id.splash_homeButton);
        registerButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}