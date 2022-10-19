package com.example.jamrockcuisine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

class BreakfastCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breakfast_category)

        val homeButton = findViewById<Button>(R.id.homeButton4)
        homeButton.setOnClickListener {
            val intent = Intent(this,Home::class.java)
            startActivity(intent);
        }

        val ackeeNSaltfish = findViewById<CardView>(R.id.ackeeNSaltfish)
        ackeeNSaltfish.setOnClickListener {
            val intent = Intent(this,Ingredients_AckeeNSaltfish::class.java)
            startActivity(intent);
        }
    }
}