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
        statement = ("INSERT INTO $RECIPES_TABLE ($REC_NAME,$REC_CATEGORY,$REC_PREP_TIME,$REC_COOK_TIME,$REC_SERVINGS,$REC_IMG_RES_ID,$REC_FAVORITES,$REC_TRENDY)"
                +" VALUES('Sweet Potato Pudding ','Dessert',30,50,10,2131165295,0,1)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $RECIPES_TABLE ($REC_NAME,$REC_CATEGORY,$REC_PREP_TIME,$REC_COOK_TIME,$REC_SERVINGS,$REC_IMG_RES_ID,$REC_FAVORITES,$REC_TRENDY)"
                +" VALUES('Coconut Drops ','Dessert',15,30,12,2131165295,0,0)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $RECIPES_TABLE ($REC_NAME,$REC_CATEGORY,$REC_PREP_TIME,$REC_COOK_TIME,$REC_SERVINGS,$REC_IMG_RES_ID,$REC_FAVORITES,$REC_TRENDY)"
                +" VALUES('Gizzada ','Dessert',45,15,1,2131165295,0,0)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $RECIPES_TABLE ($REC_NAME,$REC_CATEGORY,$REC_PREP_TIME,$REC_COOK_TIME,$REC_SERVINGS,$REC_IMG_RES_ID,$REC_FAVORITES,$REC_TRENDY)"
                +" VALUES('Fried Dumpling','Breakfast',10,15,6,2131165270,0,1)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $RECIPES_TABLE ($REC_NAME,$REC_CATEGORY,$REC_PREP_TIME,$REC_COOK_TIME,$REC_SERVINGS,$REC_IMG_RES_ID,$REC_FAVORITES,$REC_TRENDY)"
                +" VALUES('Saltfish Fritters','Breakfast',15,30,8,2131165270,0,0)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $RECIPES_TABLE ($REC_NAME,$REC_CATEGORY,$REC_PREP_TIME,$REC_COOK_TIME,$REC_SERVINGS,$REC_IMG_RES_ID,$REC_FAVORITES,$REC_TRENDY)"
                +" VALUES('Boiled Dumplings','Breakfast',10,20,15,2131165270,0,0)")
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
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(4,'Sweet Potato','2','lbs')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(4,'Flour','1','cup')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(4,'Coconut Milk','2','cups')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(4,'Dried Fruits','1 1/2','cups')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(4,'Vanilla','2','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(4,'Grated Nutmeg','1 1/2','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(4,'Mixed Spice','1','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(4,'Mixed Spice','1','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(4,'Brown Sugar','1','cup')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(4,'Salt','1','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(4,'Margarine','1','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(5,'Diced Coconut','2','cups')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(5,'Vanilla','1','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(5,'Brown Sugar','1','lb')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(5,'Salt','1','pinch')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(5,'Powdered Ginger','1','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(5,'Water','1/2','cup')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(6,'Pastry Flower','1','lb')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(6,'Sugar','1/2','tbsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(6,'Salt','1/8','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(6,'Margarine (Cold)','1/4','lb')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(6,'Shortening (Cold)','1/4','lb')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(6,'Cold Water','3/4','cup')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(6,'Cold Water','3/4','cup')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(7,'Flour','2','cups')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(7,'Baking Powder','1/2','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(7,'Vegetable Oil','1/2','cup')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(7,'Salt','1','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(7,'Water','1/4','cup')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(8,'Saltfish','4','oz')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(8,'Flour','2','cups')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(8,'Water','1','cup')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(8,'Scallion','1','stalk')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(8,'Black Pepper','1','tsp')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(8,'Salt','1','pinch')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(8,'Vegetable Oil','1/4','cup')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(9,'Water','6','cups')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(9,'Flour','3','cups')")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INGREDIENTS_TABLE ($RECIPE_ID,$INGREDIENT_NAME,$INGREDIENT_QTY,$INGREDIENT_UNITS)"
                +" VALUES(9,'Salt','1','tsp')")
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
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(4,'Wash and pare off the skin of the potatoes.',0,1)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(4,'Wash again then grate.',0,2)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(4,'Grate coconut, add water and squeeze juice through a strainer.',0,3)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(4,'Blend flour, mixed spice (raisins etc) ,salt, and nutmeg.',0,4)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(4,'Combine this mixture with the grated potatoes and mix well',0,5)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(4,'Add sugar, fruits and coconut milk. Mix well.',0,6)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(4,'Grease pan, pour in batter, bake at 350 degrees F for 50 minutes or until done.',50,7)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(5,'Place 1/2 cup of water into pot and bring to a boil.',0,1)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(5,'Combine all ingredients and add to boiling water.',0,2)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(5,'Boil for approximately 25 to 30 minutes or until very sticky.',30,3)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(5,'Line your cookie sheet with parchment paper or just use cooking spray.',0,4)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(5,'Take a serving spoon or ice cream scooper to yield one drop on a baking cookie sheet placing 1 inch apart.',0,5)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(5,' Wait until it is cool and hard to eat.',0,6)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(6,'Place flour in a large bowl, add sugar and salt and mix well.',0,1)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(6,'Shred the cold margarine and shortening, add to the flour and rub in until the mixture looks like fine breadcrumbs.',0,2)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(6,'Add cold water to the flour mixture and gently mix to form a pastry dough. Do not knead.',0,3)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(6,'Cover the pastry and place in the refrigerator to relax for about 15-18 minutes.',18,4)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(6,'Lightly dust the work surface with flour.',0,5)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(6,'Remove pastry from the refrigerator and place on the floured work surface.Use a lightly floured rolling pin to roll out the pastry.',0,6)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(6,'Use a 3 1/2 - 4 inch cutter to cut rolled pastry into circles.',0,7)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(6,'Crimp the edge using the thumb of one hand and the thumb and fore finger of the other hand.',0,8)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(6,'Place on a cookie sheet, fill each with about three tablespoons coconut mixture and bake in a pre-heated oven at 205 degrees C or 400 degrees F for 15-20 minutes.',15,9)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(7,'Combine the flour, salt and baking power in a mixing bowl.',0,1)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(7,'Gradually add water to it the dry ingredients, knead until you make a soft dough.',0,2)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(7,'Divide the dough into equal small pieces, about 6 to 7 pieces.',0,3)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(7,'Roll each pieces between the palms of your hands to from a round ball.',0,4)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(7,'In a frying pan, pour the cooking oil and put it to heat on high fire.',0,5)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(7,'Place the round dough into the heated oil. Turn the the heat down to medium low and let to dough fry on all sides.',0,6)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(7,'Fire until the flour is cooked and the dumplings are golden.',0,7)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(8,'In a medium bowl, add the all purpose flour, black pepper, saltfish, scallions and a pinch of salt.',0,1)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(8,'Use a wooden spoon to break the saltfish into smaller pieces and mix all the ingredients together.',0,2)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(8,'Once the saltfish is evenly distributed throughout the flour, gradually add water.',0,3)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(8,'Add the water a little at a time and gently stir until the batter is thick but still dripping from the spoon.',0,4)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(8,'Heat a about a half inch of oil in a large skillet.',0,5)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(8,'Once the oil is heated,  place about 2-3 tablespoon of saltfish batter an inch part in the hot oil.',0,6)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(8 ,'Fry on each side for 3 minutes each, flipping every 30 seconds.',180,7)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(8 ,'Drain the excess oil on paper towel before serving.',0,8)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(9,'In a large stockpot, add 4 cups of water. When the water starts to boil, add 1 tbsp sea salt or more. In the meantime in a bowl combine 3 cups flour and 1 tsp salt (sea salt). Mix to combine.',0,1)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(9,'Slowly add water and knead until a dough is formed, about 5 minutes. If the dough is too sticky add more flour, a little at a time. If the dumpling is too dry, add more water a little at a time and knead again.',0,2)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(9,'Take a fist sized pieces of the dough and roll in to a ball shape between your hands. Using the base of your palm press the ball in to your other palm to make a disc.',0,3)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(9,'Carefully drop the flour dumplings in to the pot of boiling water and cook for 20 minutes. Cooked dumplings will float to the top of the water.',20,4)")
        db?.execSQL(statement)
        statement = ("INSERT INTO $INSTRUCTIONS_TABLE ($RECIPE_ID,$INSTRUCTION,$INSTRUCTION_TIME,$STEP_NUMBER)"
                +" VALUES(9,'Carefully remove the boiled dumplings when cooked.',0,5)")
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
