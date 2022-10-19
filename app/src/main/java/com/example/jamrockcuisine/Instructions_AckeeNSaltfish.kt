package com.example.jamrockcuisine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.graphics.drawable.toDrawable

class Instructions_AckeeNSaltfish : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions__ackee_n_saltfish)

        var count = 0
        var step = findViewById<ImageView>(R.id.steps)
        val steps = listOf(
            R.drawable.a_s1,R.drawable.a_s2,R.drawable.a_s3,R.drawable.a_s4,R.drawable.a_s5,
            R.drawable.a_s6,R.drawable.a_s7,R.drawable.a_s8,R.drawable.a_s9,R.drawable.a_s10
        )

        val homeButton = findViewById<Button>(R.id.homeButton2)
        homeButton.setOnClickListener {
            val intent = Intent(this,Home::class.java)
            startActivity(intent);
        }

        val ingredientsButton = findViewById<Button>(R.id.ingredientsButton)
        ingredientsButton.setOnClickListener {
            val intent = Intent(this,Ingredients_AckeeNSaltfish::class.java)
            startActivity(intent);
        }

        val prevStep = findViewById<Button>(R.id.prevStep)
        prevStep.setOnClickListener {
            count -= 1
            count = count.coerceIn(0,9)
            step.setImageResource(steps[count])
        }

        val nextStep = findViewById<Button>(R.id.nextStep)
        nextStep.setOnClickListener {
            count += 1
            count = count.coerceIn(0,9)
            step.setImageResource(steps[count])
        }
    }
}