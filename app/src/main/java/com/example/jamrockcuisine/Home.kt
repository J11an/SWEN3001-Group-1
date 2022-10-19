package com.example.jamrockcuisine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val breakfast = findViewById<ImageView>(R.id.breakfastImg);
        breakfast.setOnClickListener {
            val intent = Intent(this,BreakfastCategory::class.java);
            startActivity(intent)
        }

        val lunch = findViewById<ImageView>(R.id.lunchImg);
        lunch.setOnClickListener {
            val intent = Intent(this,LunchCategory::class.java);
            startActivity(intent)
        }

        val dinner = findViewById<ImageView>(R.id.dinnerImg);
        dinner.setOnClickListener {
            val intent = Intent(this,DinnerCategory::class.java);
            startActivity(intent)
        }
        val dessert = findViewById<ImageView>(R.id.dessertImg);
        dessert.setOnClickListener {
            val intent = Intent(this,DesertCategory::class.java);
            startActivity(intent)
        }

        val recipeAckee = findViewById<Button>(R.id.viewRecipe_Ackee);
        recipeAckee.setOnClickListener {
            val intent = Intent(this,Ingredients_AckeeNSaltfish::class.java);
            startActivity(intent)
        }
    }
}