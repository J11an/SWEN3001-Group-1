package com.example.jamrockcuisine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ingredients_AckeeNSaltfish : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients__ackee_n_saltfish)

        val homeButton = findViewById<Button>(R.id.homeButton)
        homeButton.setOnClickListener {
            val intent = Intent(this,Home::class.java)
            startActivity(intent);
        }

        val instructionsButton = findViewById<Button>(R.id.ackeeInstr)
        instructionsButton.setOnClickListener {
            val intent = Intent(this,Instructions_AckeeNSaltfish::class.java)
            startActivity(intent);
        }
    }


}