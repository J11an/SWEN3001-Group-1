package com.example.jamrockcuisine.models

data class RecipeModel(
        val id: Int,
        val recipeName: String,
        val category: String,
        val prepTime: Int,
        val cookTime: Int,
        val servings: Int,
        val resId: Int,
        val isFavorite: Int,
        val isTrendy: Int,
        val ingredients: ArrayList<IngredientsModel>,
        val instructions: ArrayList<InstructionsModel>
)
