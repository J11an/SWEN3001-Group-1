package com.example.jamrockcuisine.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jamrockcuisine.R

class SearchResults : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)
        val str1 = "hello"
        val str2 = "hell"
        str1.contains(str2)
    }
}