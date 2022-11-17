package com.example.jamrockcuisine.views

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.jamrockcuisine.DBHandler
import com.example.jamrockcuisine.R

class Instructions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions)

        configureLinks()
        addRecipeInfo()
    }

    @SuppressLint("NewApi")
    private fun addRecipeInfo(){
        var count = 0
        val dbHandler = DBHandler(this)
        val recipeId = this.intent.extras?.getString("recipeId")
        val recipe = dbHandler.getRecipe(Integer.parseInt(recipeId!!))
        val instruction = findViewById<TextView>(R.id.tv_instruction)

        instruction.text = recipe.instructions[0].instruction
        findViewById<TextView>(R.id.instr_recipeName).text = recipe.recipeName

        //Getting and configuring Recipe ImageView
        val recipeImg = findViewById<ImageView>(R.id.recipeImg)
        recipeImg.setImageResource(recipe.resId)

        //Getting and Configuring TextViews for prep time, cook time and servings
        val tvPrepTime = findViewById<TextView>(R.id.prepTimeValue)
        tvPrepTime.text = "${recipe.prepTime} mins"
        val tvCookTime = findViewById<TextView>(R.id.cookTimeValue)
        tvCookTime.text = "${recipe.cookTime} mins"
        val tvServings = findViewById<TextView>(R.id.servingsValue)
        tvServings.text = "${recipe.servings}"

        val prevStep = findViewById<Button>(R.id.prevStep)
        prevStep.setOnClickListener {
            count -= 1
            count = count.coerceIn(0,recipe.instructions.size-1)
            instruction.text = recipe.instructions[count].instruction
        }

        val nextStep = findViewById<Button>(R.id.nextStep)
        nextStep.setOnClickListener {
            count += 1
            count = count.coerceIn(0,recipe.instructions.size-1)
            instruction.text = recipe.instructions[count].instruction
        }
    }

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    private fun configureLinks() {
        val recipeId = this.intent.extras?.getString("recipeId")

        val homeButton = findViewById<Button>(R.id.instr_homeButton)
        homeButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val ingredientsButton = findViewById<Button>(R.id.ingredientsButton)
        ingredientsButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("recipeId", "$recipeId")
            val intent = Intent(this, Ingredients::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}