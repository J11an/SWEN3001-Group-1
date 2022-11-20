package com.example.jamrockcuisine.views

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
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

        val favorite = findViewById<CardView>(R.id.home_favButton)
        favorite.setOnClickListener {
            switchActivity("Favorite")
        }

        val context = this
        val search = findViewById<androidx.appcompat.widget.SearchView>(R.id.searchBar)
        search.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val bundle = Bundle()
                bundle.putString("searchTerm", query)

                val intent = Intent(context,SearchResults::class.java)
                intent.putExtras(bundle)

                startActivity(intent)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })

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
            "Favourite" ->{
                val intent = Intent(this,Favourites::class.java)
                startActivity(intent)
            }
        }
    }
}