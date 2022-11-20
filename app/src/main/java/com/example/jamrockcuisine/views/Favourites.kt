package com.example.jamrockcuisine.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.jamrockcuisine.DBHandler
import com.example.jamrockcuisine.R
import com.example.jamrockcuisine.models.RecipeModel

class Favourites : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites)

        configureLinks()
        insertFavoritesInfo()
    }

    private fun insertFavoritesInfo() {
        val dbHandler = DBHandler(this)
        val recipeList = dbHandler.getRecipes("Favorites")

        val favoritesList = findViewById<LinearLayout>(R.id.favContents)

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
        val homeButton = findViewById<ImageView>(R.id.fav_homeButton)
        homeButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val backButton = findViewById<ImageView>(R.id.fav_backButton)
        backButton.setOnClickListener(){
            finish()
        }
    }
}