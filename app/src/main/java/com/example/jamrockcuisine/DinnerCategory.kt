package com.example.jamrockcuisine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class DinnerCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dinner_category)

        val catBackButton = findViewById<ImageView>(R.id.backbutton);
        catBackButton.setOnClickListener {
            val intent = Intent(this,Home::class.java);
            startActivity(intent)
        }

        val catHomeButton = findViewById<ImageView>(R.id.homebutton);
        catHomeButton.setOnClickListener {
            val intent = Intent(this,Home::class.java);
            startActivity(intent)
        }
    }
}