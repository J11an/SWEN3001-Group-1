package com.example.jamrockcuisine.views

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.jamrockcuisine.DBHandler
import com.example.jamrockcuisine.R

class Instructions : AppCompatActivity() {
    private lateinit var timer: CountDownTimer
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

        val timerMinutes = findViewById<TextView>(R.id.timerMinutes)
        val timerSeconds = findViewById<TextView>(R.id.timerSeconds)
        var isTimerActive = false

        if (recipe.instructions[0].time > 0){
            timerMinutes.text = recipe.instructions[0].time.toString()
        }

        timer = object: CountDownTimer(60000,1000){
            override fun onTick(millisUntilFinished: Long) {
                if (millisUntilFinished > 10000) {
                    val nextSecond = "${(millisUntilFinished / 1000)}"
                    timerSeconds.text = nextSecond
                }else{
                    val nextSecond = "0${(millisUntilFinished / 1000)}"
                    timerSeconds.text = nextSecond
                }
            }

            override fun onFinish() {
                if (timerMinutes.text != "0"){
                    val currentMinute = timerMinutes.text
                    val nextMinute = Integer.parseInt("$currentMinute") - 1
                    timerMinutes.text = "$nextMinute"
                    timerSeconds.text = "00"
                    timer.start()
                }else{
                    timerMinutes.text = "0"
                    timerSeconds.text = "00"
                    isTimerActive = false
                }
            }

        }

        val timerButton = findViewById<Button>(R.id.timerButton)
        timerButton.setOnClickListener {
            val currentTimerTime = Integer.parseInt("${timerMinutes.text}")

            if (currentTimerTime > 0 && !isTimerActive){
                val currentMinute = timerMinutes.text
                val nextMinute = Integer.parseInt("$currentMinute") - 1
                timerButton.text = "Reset Timer"
                timerMinutes.text = "$nextMinute"
                timer.start()
                isTimerActive = true
            }else if(isTimerActive){
                timer.cancel()
                timerMinutes.text = "${recipe.instructions[count].time}"
                timerSeconds.text = "00"
                timerButton.text = "Start Timer"
                isTimerActive = false
            }
        }


        //Getting and configuring step buttons to change instruction text on click
        val prevStep = findViewById<Button>(R.id.prevStep)
        prevStep.setOnClickListener {
            count -= 1
            count = count.coerceIn(0,recipe.instructions.size-1)
            instruction.text = recipe.instructions[count].instruction
            timer.cancel()

            if (recipe.instructions[count].time > 0) {
                timerMinutes.text = "${recipe.instructions[count].time}"
                timerSeconds.text = "00"
            }else{
                timerMinutes.text = "0"
                timerSeconds.text = "00"
            }
        }

        val nextStep = findViewById<Button>(R.id.nextStep)
        nextStep.setOnClickListener {
            count += 1
            count = count.coerceIn(0,recipe.instructions.size-1)
            instruction.text = recipe.instructions[count].instruction
            timer.cancel()

            if (recipe.instructions[count].time > 0) {
                timerMinutes.text = "${recipe.instructions[count].time}"
                timerSeconds.text = "00"
            }else{
                timerMinutes.text = "0"
                timerSeconds.text = "00"
            }
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