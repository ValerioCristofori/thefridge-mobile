package it.valeriocristofori.thefridgemobile.db.init;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "TheFridgeDB";

    // Table Names
    private static final String TABLE_USER = "User";
    private static final String TABLE_FOOD = "Food";


    // Common column names
    private static final String COLUMN_FRIDGE_ID = "id";


    // USER Table - column names
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_EMAIL = "emailAddress";
    private static final String COLUMN_PASSWORD = "password";

    // FOOD_TAGS Table - column names
    private static final String COLUMN_FOOD_NAME = "name";
    private static final String COLUMN_EXPIRATION_DATE = "expirationDate";
    private static final String COLUMN_QUANTITY = "quantity";


    // Table Create Statements

    // User table create statement
    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + COLUMN_USERNAME + " VARCHAR(30) PRIMARY KEY,"
            + COLUMN_EMAIL + " VARCHAR(50) NOT NULL," + COLUMN_PASSWORD + " VARCHAR(30) NOT NULL,"
            + COLUMN_FRIDGE_ID + " INT NOT NULL" + ")";

    // User table create statement
    private static final String CREATE_TABLE_FOOD = "CREATE TABLE "
            + TABLE_FOOD + "(" + COLUMN_FOOD_NAME + " VARCHAR(50) NOT NULL,"
            + COLUMN_FRIDGE_ID + " INT NOT NULL," + COLUMN_QUANTITY + "INT NOT NULL,"
            + COLUMN_EXPIRATION_DATE + " VARCHAR(30) DEFAULT NULL,"
            + "FOREIGN KEY(" + COLUMN_FRIDGE_ID + ")" + " REFERENCES " + TABLE_USER + "(" + COLUMN_FRIDGE_ID + ")"
            + "ON DELETE CASCADE," + "PRIMARY KEY" + "(" + COLUMN_FOOD_NAME + "," + COLUMN_FRIDGE_ID + ")" + ")";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_FOOD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD );

        //then restart db
        onCreate(db);
    }
}
