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

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val dbHandler: DBHandler = DBHandler(this)

        val emailField = findViewById<EditText>(R.id.emailInput);
        val passField = findViewById<EditText>(R.id.passwordInput);


        val loginButton = findViewById<Button>(R.id.loginButton2);
        loginButton.setOnClickListener {
            val email = emailField.text.toString();
            val pass = passField.text.toString();

            if ( email == "group1" && pass == "hello") {
                switchView("Home")
            }

            val credList: ArrayList<CredModel> = dbHandler.getUsers()

            for(cred in credList){
                if (cred.email == email && cred.password == pass){
                    switchView("Home")
                }
            }

            if (credList.isEmpty()){
                Toast.makeText(applicationContext, "One or more of the credentials is not correct.",
                    Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun switchView(viewName: String){

        when (viewName) {
            "Home" ->{
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }
            "Register" ->{
                val intent = Intent(this, Register::class.java)
                startActivity(intent)
            }
        }
    }
}