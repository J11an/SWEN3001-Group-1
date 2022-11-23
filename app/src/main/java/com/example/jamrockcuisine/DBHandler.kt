package com.example.jamrockcuisine

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.example.jamrockcuisine.models.IngredientsModel
import com.example.jamrockcuisine.models.InstructionsModel
import com.example.jamrockcuisine.models.RecipeModel

class DBHandler(context: Context) :
    SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION){

    // Companion Object containing variables for creating database tables
    companion object{

        private const val DB_VERSION = 4
        private const val DB_NAME = "AppDB"

        private const val ID = "_id"

        private const val RECIPES_TABLE = "Recipes"
        private const val REC_NAME = "recipeName"
        private const val REC_CATEGORY = "category"
        private const val REC_PREP_TIME = "prepTime"
        private const val REC_COOK_TIME = "cookingTime"
        private const val REC_SERVINGS = "servings"
        private const val REC_IMG_RES_ID = "imgResourceId"
        private const val REC_FAVORITES = "isFavorite"
        private const val REC_TRENDY = "isTrendy"

        private const val RECIPE_ID = "recipeID"

        private const val INGREDIENTS_TABLE = "Ingredients"
        private const val INGREDIENT_NAME = "ingredientName"
        private const val INGREDIENT_QTY = "quantity"
        private const val INGREDIENT_UNITS = "units"

        private const val INSTRUCTIONS_TABLE = "Instructions"
        private const val STEP_NUMBER = "stepNumber"
        private const val INSTRUCTION = "instruction"
        private const val INSTRUCTION_TIME = "instructionTime"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        createTables(db)
        populateTables(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $RECIPES_TABLE")
        db.execSQL("DROP TABLE IF EXISTS $INGREDIENTS_TABLE")
        db.execSQL("DROP TABLE IF EXISTS $INSTRUCTIONS_TABLE")
        onCreate(db)
    }

    //This function creates the tables for the database
    private fun createTables(db: SQLiteDatabase?) {
        //Creating Recipes Table
        var statement = ("CREATE TABLE $RECIPES_TABLE("
                + "$ID INTEGER PRIMARY KEY, $REC_IMG_RES_ID INTEGER,$REC_NAME TEXT,"
                + "$REC_CATEGORY TEXT,$REC_PREP_TIME INTEGER,"
                + "$REC_COOK_TIME INTEGER,$REC_SERVINGS INTEGER, $REC_FAVORITES INTEGER,"
                + "$REC_TRENDY INTEGER)")

        db?.execSQL(statement)

        //Creating Ingredients Table
        statement = ("CREATE TABLE $INGREDIENTS_TABLE("
                + "$ID INTEGER PRIMARY KEY,$RECIPE_ID INTEGER,"
                + "$INGREDIENT_NAME TEXT,$INGREDIENT_QTY TEXT,"
                + "$INGREDIENT_UNITS TEXT)")
        db?.execSQL(statement)

        //Creating Instructions Table
        statement = ("CREATE TABLE $INSTRUCTIONS_TABLE("
                + "$ID INTEGER PRIMARY KEY,$RECIPE_ID INTEGER,"
                + "$INSTRUCTION TEXT,$INSTRUCTION_TIME INTEGER,"
                + "$STEP_NUMBER INTEGER)")
        db?.execSQL(statement)
    }

    // This function populates the database table with all the recipe information
    private fun populateTables(db: SQLiteDatabase?) {
        // Populating Recipe Table with values
        var statement = ("INSERT INTO $RECIPES_TABLE ($REC_NAME,$REC_CATEGORY,$REC_PREP_TIME,$REC_COOK_TIME,$REC_SERVINGS,$REC_IMG_RES_ID,$REC_FAVORITES,$REC_TRENDY)"
                +" VALUES('Ackee and Saltfish','Breakfast',5,75,4,2131165270,0,1)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $RECIPES_TABLE ($REC_NAME,$REC_CATEGORY,$REC_PREP_TIME,$REC_COOK_TIME,$REC_SERVINGS,$REC_IMG_RES_ID,$REC_FAVORITES,$REC_TRENDY)"
                +" VALUES('Jerk Chicken','Lunch/Dinner',120,40,8,2131165315,0,0)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $RECIPES_TABLE ($REC_NAME,$REC_CATEGORY,$REC_PREP_TIME,$REC_COOK_TIME,$REC_SERVINGS,$REC_IMG_RES_ID,$REC_FAVORITES,$REC_TRENDY)"
                +" VALUES('Grater Cake','Dessert',30,45,8,2131165295,0,0)")
        db?.execSQL(statement)


        // Populating Ingredients Table with values
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Saltfish','225','g')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Vegetable Oil','2','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Diced Onion','2','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Diced Bell Pepper','2','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Fresh Thyme Leaves','2','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Garlic','2','cloves')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Ackee','20','oz')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Scallion','1','')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Small Diced Tomato','1','')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Scotch Bonnet Pepper','1/2','')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(2,'Medium Onion','1','')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(2,'Medium Scallion','3','')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(2,'Scotch Bonnet Chiles','2','')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(2,'Garlic','2','cloves')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(2,'Five-Spice Powder','1','tbsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(2,'AllSpice Berries','1','tbsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(2,'Ground Pepper','1','tbsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(2,'Dried Thyme','1','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(2,'Grated Nutmeg','1','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(2,'Salt','1','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(2,'Soy Sauce','1/2','cup')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(2,'Vegetable Oil','1','tbsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(2,'4-Pound Chickens','4','')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(3,'Dried Coconut','3','cups')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(3,'Granulated Sugar','2','cups')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(3,'Water','1/4','cup')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(3,'Almond essence','1/8','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(3,'Salt','1/4','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(3,'Red Food Coloring','1','tsp')")
        db?.execSQL(statement)


        // Populate instructions table with values
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(1,'Put saltfish to soak in cold water for 1 hour',60,1)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(1,'Drain saltfish and transfer to small saucepan. Cover with fresh water and bring to boil over medium-high heat',0,2)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(1,'Cook until saltfish flakes easily when proded with a fork',40,3)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(1,'Taste test (it should have similar salinity to bacon) and if it is too salty, drain the saltfish and boil it again with fresh water in the saucepan.',20,4)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(1,'Once the saltfish is cooked, drain it and flake it into 1/2 to 1 inch pieces, discarding any bones and slivery membranes then set aside.',0,5)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(1,'In a 12 inch skillet, heat vegetable oil over medium heat until shimmering, then add onions, bell pepper, scotch bonnet, garlic and cook while stirring occasionally',5,6)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(1,'Add flaked saltfish and cook, stirring occasionally until fish is heated through.',5,7)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(1,'Add tomato, scallion, thyme and cook while stirring until vegetables are tender and mixture is aromatic.',5,8)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(1,'Add ackee, stir gently to incoporate, taking care not to over-mix causing ackee to be mushy and cook until ackee is heated through.',3,9)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(1,'Season with salt and pepper to taste and serve immediately with fried breadfruit or fried dumplings.',0,10)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(2,'In a food processor, combine the onion, scallions, chiles, garlic, five-spice powder, allspice, pepper, thyme, nutmeg and salt; process to a coarse paste.',0,1)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(2,'With the machine on, add the soy sauce and oil in a steady stream.',0,2)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(2,'Pour the marinade into a large bowl, add the chicken and turn to coat. Cover and refrigerate for 2 hours (better if left overnight)',120,3)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(2,'Bring the chicken to room temperature before proceeding.',0,4)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(2,'Light a grill. Grill the chicken over a medium-hot fire, turning occasionally, until well browned and cooked through, 35 to 40 minutes. (Cover the grill for a smokier flavor.) ',40,5)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(2,'Transfer the chicken to a platter and serve.',0,6)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(3,'Peel off the brown portion of the coconut, wash, grate and set aside.',0,1)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(3,'Combine grated coconut, granulated sugar and water in a pot and put to boil. Reduce to medium flame, mix in the almond essence and the salt. Stir constantly until mixture thickens.',45,2)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(3,'Remove a 1/3 of the mixture and add a small amount of red food colouring to give a delicate pink colour.',0,3)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(3,'Scrape remaining coconut mixture into a greased casserole dish and spread evenly.',0,4)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(3,'Spread the pink coloured coconut evenly over the white mixture.',0,5)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(3,'Set aside for 25-30 minutes or until sufficiently cooled.',30,6)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(3,'Cut into squares and serve.',0,7)")
        db?.execSQL(statement)
    }

    //This function returns an arraylist of RecipeModels containing recipe information depending on the category entered in the parameters
    @SuppressLint("Range")
     fun getRecipes(category: String): ArrayList<RecipeModel>{
        val recipeList = ArrayList<RecipeModel>()

        val statement = when (category) {
            "Favorites" -> {
                "SELECT * FROM $RECIPES_TABLE WHERE $REC_FAVORITES = 1"
            }
            "Trending" -> {
                "SELECT * FROM $RECIPES_TABLE WHERE $REC_TRENDY = 1"
            }
            "All" -> {
                "SELECT * FROM $RECIPES_TABLE"
            }
            else -> {
                "SELECT * FROM $RECIPES_TABLE WHERE $REC_CATEGORY = '$category'"
            }
        }

        val statement2 = "SELECT * FROM $INGREDIENTS_TABLE"
        val statement3 = "SELECT * FROM $INSTRUCTIONS_TABLE"

        val db = this.readableDatabase

        val recipeCursor: Cursor?
        val ingredientsCursor: Cursor?
        val instructionsCursor: Cursor?

        try {
            recipeCursor = db.rawQuery(statement, null)
            ingredientsCursor = db.rawQuery(statement2, null)
            instructionsCursor = db.rawQuery(statement3, null)
        } catch (e: SQLiteException){
            db.execSQL(statement)
            db.execSQL(statement2)
            db.execSQL(statement3)
            return recipeList
        }


        if (recipeCursor.moveToFirst()){
            do{
                val id = recipeCursor.getInt(recipeCursor.getColumnIndex(ID))
                val name = recipeCursor.getString(recipeCursor.getColumnIndex(REC_NAME))
                val recCategory = recipeCursor.getString(recipeCursor.getColumnIndex(REC_CATEGORY))
                val prepTime = recipeCursor.getInt(recipeCursor.getColumnIndex(REC_PREP_TIME))
                val cookTime = recipeCursor.getInt(recipeCursor.getColumnIndex(REC_COOK_TIME))
                val servings = recipeCursor.getInt(recipeCursor.getColumnIndex(REC_SERVINGS))
                val resId = recipeCursor.getInt(recipeCursor.getColumnIndex(REC_IMG_RES_ID))
                val isFavorite = recipeCursor.getInt(recipeCursor.getColumnIndex(REC_FAVORITES))
                val isTrendy = recipeCursor.getInt(recipeCursor.getColumnIndex(REC_TRENDY))
                val ingredients: ArrayList<IngredientsModel> = ArrayList()
                val instructions: ArrayList<InstructionsModel> = ArrayList()

                if (ingredientsCursor.moveToFirst()){
                    do{
                        val recipeId = ingredientsCursor.getInt(ingredientsCursor.getColumnIndex(RECIPE_ID))

                        if (recipeId == id){
                            val ingredient = IngredientsModel(
                                    ingredientsCursor.getInt(ingredientsCursor.getColumnIndex(ID)),
                                    ingredientsCursor.getString(ingredientsCursor.getColumnIndex(INGREDIENT_NAME)),
                                    ingredientsCursor.getString(ingredientsCursor.getColumnIndex(INGREDIENT_QTY)),
                                    ingredientsCursor.getString(ingredientsCursor.getColumnIndex(INGREDIENT_UNITS))
                            )

                            ingredients.add(ingredient)
                        }
                    }while (ingredientsCursor.moveToNext())
                }

                if (instructionsCursor.moveToFirst()){
                    do{
                        val recipeId = instructionsCursor.getInt(instructionsCursor.getColumnIndex(RECIPE_ID))

                        if (recipeId == id){
                            val instruction = InstructionsModel(
                                instructionsCursor.getInt(instructionsCursor.getColumnIndex(ID)),
                                instructionsCursor.getInt(instructionsCursor.getColumnIndex(STEP_NUMBER)),
                                instructionsCursor.getString(instructionsCursor.getColumnIndex(INSTRUCTION)),
                                instructionsCursor.getInt(instructionsCursor.getColumnIndex(INSTRUCTION_TIME)),
                            )

                            instructions.add(instruction)
                        }
                    }while (instructionsCursor.moveToNext())
                }

                val recipe = RecipeModel(
                    id,
                    name,
                    recCategory,
                    prepTime,
                    cookTime,
                    servings,
                    resId,
                    isFavorite,
                    isTrendy,
                    ingredients,
                    instructions
                )

                recipeList.add(recipe)
            } while (recipeCursor.moveToNext())
        }

        recipeCursor.close()
        ingredientsCursor.close()
        instructionsCursor.close()
        db.close()
        return recipeList
    }

    //This function returns a specific RecipeModel containing information about a recipe dependent on the id in the parameters
    @SuppressLint("Range")
    fun getRecipe(recId: Int): RecipeModel{
        var recipe = RecipeModel(0,"","",0,0,0,0,0,0,ArrayList(),ArrayList())

        val statement = "SELECT * FROM $RECIPES_TABLE WHERE $ID = '$recId'"
        val statement2 = "SELECT * FROM $INGREDIENTS_TABLE"
        val statement3 = "SELECT * FROM $INSTRUCTIONS_TABLE"

        val db = this.readableDatabase

        val recipeCursor: Cursor?
        val ingredientsCursor: Cursor?
        val instructionsCursor: Cursor?

        try {
            recipeCursor = db.rawQuery(statement, null)
            ingredientsCursor = db.rawQuery(statement2, null)
            instructionsCursor = db.rawQuery(statement3, null)
        } catch (e: SQLiteException){
            db.execSQL(statement)
            db.execSQL(statement2)
            db.execSQL(statement3)
            return recipe
        }


        if (recipeCursor.moveToFirst()){
            do{
                val id = recipeCursor.getInt(recipeCursor.getColumnIndex(ID))
                val name = recipeCursor.getString(recipeCursor.getColumnIndex(REC_NAME))
                val recCategory = recipeCursor.getString(recipeCursor.getColumnIndex(REC_CATEGORY))
                val prepTime = recipeCursor.getInt(recipeCursor.getColumnIndex(REC_PREP_TIME))
                val cookTime = recipeCursor.getInt(recipeCursor.getColumnIndex(REC_COOK_TIME))
                val servings = recipeCursor.getInt(recipeCursor.getColumnIndex(REC_SERVINGS))
                val resId = recipeCursor.getInt(recipeCursor.getColumnIndex(REC_IMG_RES_ID))
                val isFavorite = recipeCursor.getInt(recipeCursor.getColumnIndex(REC_FAVORITES))
                val isTrendy = recipeCursor.getInt(recipeCursor.getColumnIndex(REC_TRENDY))
                val ingredients: ArrayList<IngredientsModel> = ArrayList()
                val instructions: ArrayList<InstructionsModel> = ArrayList()

                if (ingredientsCursor.moveToFirst()){
                    do{
                        val recipeId = ingredientsCursor.getInt(ingredientsCursor.getColumnIndex(RECIPE_ID))

                        if (recipeId == id){
                            val ingredient = IngredientsModel(
                                    ingredientsCursor.getInt(ingredientsCursor.getColumnIndex(ID)),
                                    ingredientsCursor.getString(ingredientsCursor.getColumnIndex(INGREDIENT_NAME)),
                                    ingredientsCursor.getString(ingredientsCursor.getColumnIndex(INGREDIENT_QTY)),
                                    ingredientsCursor.getString(ingredientsCursor.getColumnIndex(INGREDIENT_UNITS))
                            )

                            ingredients.add(ingredient)
                        }
                    }while (ingredientsCursor.moveToNext())
                }

                if (instructionsCursor.moveToFirst()){
                    do{
                        val recipeId = instructionsCursor.getInt(instructionsCursor.getColumnIndex(RECIPE_ID))

                        if (recipeId == id){
                            val instruction = InstructionsModel(
                                    instructionsCursor.getInt(instructionsCursor.getColumnIndex(ID)),
                                    instructionsCursor.getInt(instructionsCursor.getColumnIndex(STEP_NUMBER)),
                                    instructionsCursor.getString(instructionsCursor.getColumnIndex(INSTRUCTION)),
                                    instructionsCursor.getInt(instructionsCursor.getColumnIndex(INSTRUCTION_TIME))
                            )

                            instructions.add(instruction)
                        }
                    }while (instructionsCursor.moveToNext())
                }

                recipe = RecipeModel(
                    id,
                    name,
                    recCategory,
                    prepTime,
                    cookTime,
                    servings,
                    resId,
                    isFavorite,
                    isTrendy,
                    ingredients,
                    instructions
                )
            } while (recipeCursor.moveToNext())
        }

        recipeCursor.close()
        ingredientsCursor.close()
        instructionsCursor.close()
        db.close()
        return recipe
    }

    fun setFavorite(recipeId: Int,isFavorite: Int){
        val db = this.readableDatabase
        val statement =
        if (isFavorite == 0){
            "UPDATE $RECIPES_TABLE SET $REC_FAVORITES = 1 WHERE $ID = $recipeId"
        }else{
            "UPDATE $RECIPES_TABLE SET $REC_FAVORITES = 0 WHERE $ID = $recipeId"
        }

        db.execSQL(statement)
        db.close()
    }
}
