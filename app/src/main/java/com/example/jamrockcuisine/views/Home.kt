package com.example.jamrockcuisine.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.jamrockcuisine.R

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        configureLinks()
    }

    private fun configureLinks() {
        val breakfast = findViewById<ImageView>(R.id.breakfastImg)
        breakfast.setOnClickListener {
            switchActivity("Breakfast_Category")
        }

        val lunch = findViewById<ImageView>(R.id.lunchImg)
        lunch.setOnClickListener {
            switchActivity("Lunch_Category")
        }

        val dinner = findViewById<ImageView>(R.id.dinnerImg)
        dinner.setOnClickListener {
            switchActivity("Dinner_Category")
        }
        val dessert = findViewById<ImageView>(R.id.dessertImg)
        dessert.setOnClickListener {
            switchActivity("Dessert_Category")
        }

        val recipeAckee = findViewById<Button>(R.id.viewRecipe_Ackee)
        recipeAckee.setOnClickListener {
            switchActivity("Ackee_and_Saltfish")
        }
    }

    private fun switchActivity(viewName: String){
        val bundle = Bundle()

        when (viewName) {
            "Breakfast_Category" ->{
                val intent = Intent(this, Category::class.java)
                bundle.putString("category", "Breakfast")
                intent.putExtras(bundle)
                startActivity(intent)
            }
            "Lunch_Category" ->{
                val intent = Intent(this, Category::class.java)
                bundle.putString("category", "Lunch")
                intent.putExtras(bundle)
                startActivity(intent)
            }
            "Dinner_Category" ->{
                val intent = Intent(this, Category::class.java)
                bundle.putString("category", "Dinner")
                intent.putExtras(bundle)
                startActivity(intent)
            }
            "Dessert_Category" ->{
                val intent = Intent(this, Category::class.java)
                bundle.putString("category", "Dessert")
                intent.putExtras(bundle)
                startActivity(intent)
            }
            "Ackee_and_Saltfish" ->{
                val intent = Intent(this,Ingredients::class.java)
                val bundle = Bundle()
                bundle.putString("recipeId", "1")
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}