package com.example.jamrockcuisine

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.example.jamrockcuisine.models.CredModel
import com.example.jamrockcuisine.models.IngredientsModel
import com.example.jamrockcuisine.models.InstructionsModel
import com.example.jamrockcuisine.models.RecipeModel

class DBHandler(context: Context) :
    SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION){

    // Companion Object containing variables for creating database tables
    companion object{
        private const val DB_VERSION = 2
        private const val DB_NAME = "AppDB"

        private const val CREDENTIALS_TABLE = "Credentials"
        private const val ID = "_id"
        private const val CRED_EMAIL = "email"
        private const val CRED_PASSWORD = "password"

        private const val RECIPES_TABLE = "Recipes"
        private const val REC_NAME = "recipeName"
        private const val REC_CATEGORY = "category"
        private const val REC_PREP_TIME = "prepTime"
        private const val REC_COOK_TIME = "cookingTime"
        private const val REC_SERVINGS = "servings"
        private const val REC_IMG_RES_ID = "imgResourceId"

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

    // This function populates the database table with all the recipe information
    private fun populateTables(db: SQLiteDatabase?) {
        // Adding ackee and saltfish recipe to database
        var statement = ("INSERT INTO $RECIPES_TABLE ($REC_NAME,$REC_CATEGORY,$REC_PREP_TIME,$REC_COOK_TIME,$REC_SERVINGS,$REC_IMG_RES_ID)"
                +" VALUES('Ackee and Saltfish','Breakfast',5,75,4,2131165280)")
        db?.execSQL(statement)

        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Saltfish',225,'g')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Vegetable Oil',2,'tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Diced Onion',2,'tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Diced Bell Pepper',2,'tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Fresh Thyme Leaves',2,'tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Garlic',2,'cloves')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Ackee',20,'oz')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Scallion',1,'')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Small Diced Tomato',1,'')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(1,'Scotch Bonnet Pepper',1,'')")
        db?.execSQL(statement)

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
    }

    //This function creates the tables for the database
    private fun createTables(db: SQLiteDatabase?) {
        //Creating Credentials table
        var statement = ("CREATE TABLE $CREDENTIALS_TABLE("
                + "$ID INTEGER PRIMARY KEY,$CRED_EMAIL TEXT,"
                + "$CRED_PASSWORD TEXT)")
        db?.execSQL(statement)

        //Creating Recipes Table
        statement = ("CREATE TABLE $RECIPES_TABLE("
                + "$ID INTEGER PRIMARY KEY, $REC_IMG_RES_ID INTEGER,$REC_NAME TEXT,"
                + "$REC_CATEGORY TEXT,$REC_PREP_TIME INTEGER,"
                + "$REC_COOK_TIME INTEGER,$REC_SERVINGS INTEGER)")

        db?.execSQL(statement)

        //Creating Ingredients Table
        statement = ("CREATE TABLE $INGREDIENTS_TABLE("
                + "$ID INTEGER PRIMARY KEY,$RECIPE_ID INTEGER,"
                + "$INGREDIENT_NAME TEXT,$INGREDIENT_QTY INTEGER,"
                + "$INGREDIENT_UNITS TEXT)")
        db?.execSQL(statement)

        //Creating Instructions Table
        statement = ("CREATE TABLE $INSTRUCTIONS_TABLE("
                + "$ID INTEGER PRIMARY KEY,$RECIPE_ID INTEGER,"
                + "$INSTRUCTION TEXT,$INSTRUCTION_TIME INTEGER,"
                + "$STEP_NUMBER INTEGER)")
        db?.execSQL(statement)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $CREDENTIALS_TABLE")
        db.execSQL("DROP TABLE IF EXISTS $RECIPES_TABLE")
        db.execSQL("DROP TABLE IF EXISTS $INGREDIENTS_TABLE")
        db.execSQL("DROP TABLE IF EXISTS $INSTRUCTIONS_TABLE")
        onCreate(db)
    }

    //This function adds a user's information to the Credentials table
    fun addUser(credential: CredModel): Long{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(CRED_EMAIL, credential.email)
        contentValues.put(CRED_PASSWORD, credential.password)

        val success = db.insert(CREDENTIALS_TABLE, null, contentValues)

        db.close()
        return  success
    }

    /*
    @SuppressLint("Range")
    fun addRecipe(recipe: RecipeModel): Long{
        val db = this.writableDatabase

        val ingredients = recipe.ingredients
        val instructions = recipe.instructions
        val contentValues = ContentValues()

        contentValues.put(REC_NAME, recipe.recipeName)
        contentValues.put(REC_CATEGORY, recipe.category)
        contentValues.put(REC_PREP_TIME, recipe.prepTime)
        contentValues.put(REC_COOK_TIME, recipe.cookTime)
        contentValues.put(REC_SERVINGS, recipe.servings)

        var success = db.insert(RECIPES_TABLE, null, contentValues)

        val statement = "SELECT * FROM $RECIPES_TABLE WHERE $REC_NAME == ${recipe.recipeName}"
        val cursor: Cursor?

        try {
            cursor = db.rawQuery(statement, null)
        } catch (e: SQLiteException){
            db.execSQL(statement)
            return success
        }

        cursor.moveToFirst()
        val id = cursor.getInt(cursor.getColumnIndex(ID))
        cursor.close()

        for (ingredient in ingredients){
            contentValues.clear()
            contentValues.put(RECIPE_ID, id)
            contentValues.put(INGREDIENT_NAME, ingredient.name)
            contentValues.put(INGREDIENT_QTY, ingredient.quantity)
            contentValues.put(INGREDIENT_UNITS, ingredient.units)
            success = db.insert(INGREDIENTS_TABLE, null, contentValues)
        }

        for (instruction in instructions){
            contentValues.clear()
            contentValues.put(RECIPE_ID, id)
            contentValues.put(STEP_NUMBER, instruction.stepNumber)
            contentValues.put(INSTRUCTION, instruction.instruction)
            contentValues.put(INSTRUCTION_TIME, instruction.time)
            success = db.insert(INSTRUCTIONS_TABLE, null, contentValues)
        }

        db.close()
        return  success
    }

     */

    //This function returns an arraylist of CredModels containing user's credential information
    @SuppressLint("Range")
     fun getUsers(): ArrayList<CredModel>{
        //onUpgrade(this.writableDatabase,this.writableDatabase.version,this.writableDatabase.version+1)
        val credList = ArrayList<CredModel>()

        val statement = "SELECT * FROM $CREDENTIALS_TABLE"
        val db = this.readableDatabase
        val cursor: Cursor?

        try {
            cursor = db.rawQuery(statement, null)
        } catch (e: SQLiteException){
            db.execSQL(statement)
            return ArrayList()
        }

        var id: Int
        var email: String
        var password: String

        if (cursor.moveToFirst()){
            do{
                id = cursor.getInt(cursor.getColumnIndex(ID))
                email = cursor.getString(cursor.getColumnIndex(CRED_EMAIL))
                password = cursor.getString(cursor.getColumnIndex(CRED_PASSWORD))

                val cred = CredModel(id, email, password)
                credList.add(cred)

            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        getRecipes("All")
        return credList
    }

    //This function returns an arraylist of RecipeModels containing recipe information depending on the category entered in the parameters
    @SuppressLint("Range")
     fun getRecipes(category: String): ArrayList<RecipeModel>{
        val recipeList = ArrayList<RecipeModel>()

        val statement = if (category == "All") {
            "SELECT * FROM $RECIPES_TABLE"
        }else{
            "SELECT * FROM $RECIPES_TABLE WHERE $REC_CATEGORY = '$category'"
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
                val ingredients: ArrayList<IngredientsModel> = ArrayList()
                val instructions: ArrayList<InstructionsModel> = ArrayList()

                if (ingredientsCursor.moveToFirst()){
                    do{
                        val recipeId = ingredientsCursor.getInt(ingredientsCursor.getColumnIndex(RECIPE_ID))

                        if (recipeId == id){
                            val ingredient = IngredientsModel(
                                    ingredientsCursor.getInt(ingredientsCursor.getColumnIndex(ID)),
                                    ingredientsCursor.getString(ingredientsCursor.getColumnIndex(INGREDIENT_NAME)),
                                    ingredientsCursor.getInt(ingredientsCursor.getColumnIndex(INGREDIENT_QTY)),
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
                    ingredients,
                    instructions
                )

                recipeList.add(recipe)
            } while (recipeCursor.moveToNext())
        }

        recipeCursor.close()
        ingredientsCursor.close()
        instructionsCursor.close()
        //db.close()
        return recipeList
    }

    //This function returns a specific RecipeModel containing information about a recipe dependent on the id in the parameters
    @SuppressLint("Range")
    fun getRecipe(recId: Int): RecipeModel{
        var recipe = RecipeModel(0,"","",0,0,0,0,ArrayList(),ArrayList())


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
                val ingredients: ArrayList<IngredientsModel> = ArrayList()
                val instructions: ArrayList<InstructionsModel> = ArrayList()

                if (ingredientsCursor.moveToFirst()){
                    do{
                        val recipeId = ingredientsCursor.getInt(ingredientsCursor.getColumnIndex(RECIPE_ID))

                        if (recipeId == id){
                            val ingredient = IngredientsModel(
                                    ingredientsCursor.getInt(ingredientsCursor.getColumnIndex(ID)),
                                    ingredientsCursor.getString(ingredientsCursor.getColumnIndex(INGREDIENT_NAME)),
                                    ingredientsCursor.getInt(ingredientsCursor.getColumnIndex(INGREDIENT_QTY)),
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
}