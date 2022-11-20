package com.example.jamrockcuisine.views

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.jamrockcuisine.DBHandler
import com.example.jamrockcuisine.R

class Ingredients : AppCompatActivity() {
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)

        val recipeId = Integer.parseInt(this.intent.extras?.getString("recipeId"))
        configureLinks(recipeId)
        addRecipeInfo(recipeId)
    }

    private fun addRecipeInfo(recipeId: Int) {
        val dbHandler = DBHandler(this)
        val recipe = dbHandler.getRecipe(recipeId)

        //Getting and configuring Recipe Name textview
        val recipeName = findViewById<TextView>(R.id.ingr_RecipeName)
        recipeName.text = "${recipe.recipeName}"

        //Getting and configuring Recipe ImageView
        val recipeImg = findViewById<ImageView>(R.id.recipeImg)
        recipeImg.setImageResource(recipe.resId)
        println("${recipe.resId}")

        //Getting and Configuring TextViews for prep time, cook time and servings
        val tvPrepTime = findViewById<TextView>(R.id.prepTimeValue)
        tvPrepTime.text = "${recipe.prepTime} mins"
        val tvCookTime = findViewById<TextView>(R.id.cookTimeValue)
        tvCookTime.text = "${recipe.cookTime} mins"
        val tvServings = findViewById<TextView>(R.id.servingsValue)
        tvServings.text = "${recipe.servings}"

        val ingrNameLinLayout = findViewById<LinearLayout>(R.id.ingr_ingrNameLinLaayout)
        val ingrQtyLinLayout = findViewById<LinearLayout>(R.id.ingr_ingrQtyLinLayout)

        for (ingredient in recipe.ingredients){
            var linParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            linParams.setMargins(20,10,0,10)
            val ingredientName = TextView(this)
            ingredientName.text = ingredient.name
            ingredientName.textSize = 18f
            ingredientName.setTextColor(Color.BLACK)
            ingredientName.layoutParams = linParams
            ingrNameLinLayout.addView(ingredientName)

            val ingredientsQty = TextView(this)
            linParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            linParams.setMargins(0,10,20,10)
            ingredientsQty.text = "${ingredient.quantity} ${ingredient.units}"
            ingredientsQty.gravity = Gravity.CENTER
            ingredientsQty.textSize = 18f
            ingredientsQty.setTextColor(Color.parseColor("#FF5722"))
            ingredientsQty.setTypeface(null, Typeface.BOLD);
            ingredientsQty.layoutParams = linParams
            ingrQtyLinLayout.addView(ingredientsQty)
        }
    }

    private fun configureLinks(recipeId: Int){
        val homeButton = findViewById<ImageView>(R.id.recipeHomeButton)
        homeButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val bkButton = findViewById<ImageView>(R.id.bkbtn)
        bkButton.setOnClickListener(){
            finish()
        }

        val instructionsButton = findViewById<Button>(R.id.ingr_instructionsButton)
        instructionsButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("recipeId", "$recipeId")
            val intent = Intent(this, Instructions::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}