package com.example.jamrockcuisine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class DesertCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desert_category)

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

        val breakfast = findViewById<ImageView>(R.id.breakfastcategory);
        breakfast.setOnClickListener {
            val intent = Intent(this,BreakfastCategory::class.java);
            startActivity(intent)
        }

        val lunch = findViewById<ImageView>(R.id.lunchcategory);
        lunch.setOnClickListener {
            val intent = Intent(this,LunchCategory::class.java);
            startActivity(intent)
        }

        val dinner = findViewById<ImageView>(R.id.dinnercategory1);
        dinner.setOnClickListener {
            val intent = Intent(this,DinnerCategory::class.java);
            startActivity(intent)
        }

        val dessert = findViewById<ImageView>(R.id.desertcategory);
        dessert.setOnClickListener {
            val intent = Intent(this,DesertCategory::class.java);
            startActivity(intent)
        }



    }
}