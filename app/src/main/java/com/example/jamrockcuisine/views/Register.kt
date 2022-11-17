package com.example.jamrockcuisine.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jamrockcuisine.DBHandler
import com.example.jamrockcuisine.R
import com.example.jamrockcuisine.models.CredModel

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val dbHandler: DBHandler = DBHandler(this)

        val emailField = findViewById<EditText>(R.id.register_email);
        val passField = findViewById<EditText>(R.id.register_password);
        val confirmPassField = findViewById<EditText>(R.id.register_confirm_password);

        val registerButton = findViewById<Button>(R.id.register_reg_button);
        registerButton.setOnClickListener {
            val email = emailField.text.toString();
            val password = passField.text.toString();
            val confirmPassword = confirmPassField.text.toString();

            if (password == confirmPassword){
                val credential: CredModel = CredModel(0,email,password)
                val status = dbHandler.addUser(credential)

                if (status > -1){
                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(applicationContext, "An error occured while trying to register. Please Try again.",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(applicationContext, "Password and confirm password must be the same.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}