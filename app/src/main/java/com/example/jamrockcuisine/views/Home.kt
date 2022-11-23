package com.example.jamrockcuisine.views

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.jamrockcuisine.DBHandler
import com.example.jamrockcuisine.R

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        configureLinks()
        getTrendy()
    }

    private fun getTrendy() {
        val dbHandler = DBHandler(this)
        val recipeList = dbHandler.getRecipes("Trending")

        val favoritesList = findViewById<LinearLayout>(R.id.trendy_contents)

        for (recipe in recipeList){
            //Creating variables of recipe information for later use
            val recipeId = recipe.id
            val recipeName = recipe.recipeName
            val prepTime = recipe.prepTime
            val cookTime = recipe.cookTime
            val servings = recipe.servings

            //Creating and configuring CardView
            var linearParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 336)
            linearParams.setMargins(0,0,0,53)
            val recipeCard = CardView(this)
            recipeCard.layoutParams = linearParams
            recipeCard.isClickable = true
            recipeCard.isFocusable = true
            recipeCard.setOnClickListener{
                val intent = Intent(this,Ingredients::class.java)
                val bundle = Bundle()
                bundle.putString("recipeId", "$recipeId")
                intent.putExtras(bundle)
                startActivity(intent)
            }
            favoritesList.addView(recipeCard)

            //TODO Access ImageView and set the image resource based on resource id in RecipeModel

            //Creating and configuring horizontal linear layout
            linearParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            val horLayout = LinearLayout(this)
            horLayout.orientation = LinearLayout.HORIZONTAL
            horLayout.layoutParams = linearParams
            recipeCard.addView(horLayout)

            //Creating and configuring ImageView
            linearParams = LinearLayout.LayoutParams(200, LinearLayout.LayoutParams.WRAP_CONTENT)
            linearParams.gravity = Gravity.CENTER
            linearParams.setMargins(20,0,20,0)
            val recipeImg = ImageView(this)
            recipeImg.layoutParams = linearParams
            recipeImg.setImageResource(recipe.resId)
            horLayout.addView(recipeImg)

            //Creating and configuring Recipe Title TextView
            linearParams = LinearLayout.LayoutParams(200, LinearLayout.LayoutParams.MATCH_PARENT)
            val tvRecipeName = TextView(this)
            tvRecipeName.layoutParams = linearParams
            tvRecipeName.text = recipeName
            tvRecipeName.gravity = Gravity.CENTER
            horLayout.addView(tvRecipeName)

            //Creating and configuring vertical linear layout for prep time
            val prepVertLayout = LinearLayout(this)
            prepVertLayout.layoutParams = linearParams
            prepVertLayout.orientation = LinearLayout.VERTICAL
            horLayout.addView(prepVertLayout)

            //Creating and configuring vertical linear layout for cook time
            val cookVertLayout = LinearLayout(this)
            cookVertLayout.layoutParams = linearParams
            cookVertLayout.orientation = LinearLayout.VERTICAL
            horLayout.addView(cookVertLayout)

            //Creating and configuring vertical linear layout for servings
            val servingsVertLayout = LinearLayout(this)
            servingsVertLayout.layoutParams = linearParams
            servingsVertLayout.orientation = LinearLayout.VERTICAL
            horLayout.addView(servingsVertLayout)

            //Creating and configuring TextViews for Prep Time
            linearParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 168)
            linearParams.setMargins(20,0,0,0)
            val tvPrepTitle = TextView(this)
            tvPrepTitle.text = "Prep Time"
            tvPrepTitle.layoutParams = linearParams
            tvPrepTitle.gravity = Gravity.CENTER
            prepVertLayout.addView(tvPrepTitle)
            val tvPrepValue = TextView(this)
            tvPrepValue.text = "$prepTime mins"
            tvPrepValue.layoutParams = linearParams
            tvPrepValue.gravity = Gravity.CENTER
            prepVertLayout.addView(tvPrepValue)

            //Creating and configuring TextViews for Cook Time
            val tvCookTitle = TextView(this)
            tvCookTitle.text = "Cook Time"
            tvCookTitle.layoutParams = linearParams
            tvCookTitle.gravity = Gravity.CENTER
            cookVertLayout.addView(tvCookTitle)
            val tvCookValue = TextView(this)
            tvCookValue.text = "$cookTime mins"
            tvCookValue.layoutParams = linearParams
            tvCookValue.gravity = Gravity.CENTER
            cookVertLayout.addView(tvCookValue)

            //Creating and configuring TextViews for Servings
            val tvServingsTitle = TextView(this)
            tvServingsTitle.text = "Servings"
            tvServingsTitle.layoutParams = linearParams
            tvServingsTitle.gravity = Gravity.CENTER
            servingsVertLayout.addView(tvServingsTitle)
            val tvServingsValue = TextView(this)
            tvServingsValue.text = servings.toString()
            tvServingsValue.layoutParams = linearParams
            tvServingsValue.gravity = Gravity.CENTER
            servingsVertLayout.addView(tvServingsValue)
        }
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

        val dessert = findViewById<ImageView>(R.id.dessertImg)
        dessert.setOnClickListener {
            switchActivity("Dessert_Category")
        }

        val favorite = findViewById<CardView>(R.id.home_favButton)
        favorite.setOnClickListener {
            switchActivity("Favourites")
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
                bundle.putString("category", "Lunch/Dinner")
                intent.putExtras(bundle)
                startActivity(intent)
            }
            "Dessert_Category" ->{
                val intent = Intent(this, Category::class.java)
                bundle.putString("category", "Dessert")
                intent.putExtras(bundle)
                startActivity(intent)
            }
            "Favourites" ->{
                val intent = Intent(this,Favourites::class.java)
                startActivity(intent)
            }
        }
    }
}