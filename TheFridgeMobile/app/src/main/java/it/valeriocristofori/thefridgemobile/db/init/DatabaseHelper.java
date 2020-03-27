package it.valeriocristofori.thefridgemobile.db.init;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import it.valeriocristofori.thefridgemobile.model.entity.Fridge;
import it.valeriocristofori.thefridgemobile.model.entity.User;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper instance = null;

    // Database Version
    private static final int DATABASE_VERSION = 2;

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
            + TABLE_USER + "(" + COLUMN_USERNAME + " TEXT PRIMARY KEY, "
            + COLUMN_EMAIL + " TEXT, " + COLUMN_PASSWORD + " TEXT, "
            + COLUMN_FRIDGE_ID + " INTEGER " + ")";

    // User table create statement
    private static final String CREATE_TABLE_FOOD = "CREATE TABLE "
            + TABLE_FOOD + "(" + COLUMN_FOOD_NAME + " TEXT, "
            + COLUMN_FRIDGE_ID + " INTEGER, " + COLUMN_QUANTITY + "INTEGER, "
            + COLUMN_EXPIRATION_DATE + " TEXT, "
            + "FOREIGN KEY (" + COLUMN_FRIDGE_ID + ")" + " REFERENCES " + TABLE_USER + "(" + COLUMN_FRIDGE_ID + ")"
            + " ON DELETE CASCADE, " + "PRIMARY KEY" + "(" + COLUMN_FOOD_NAME + "," + COLUMN_FRIDGE_ID + ")" + ")";


    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getDatabaseInstance(Context context){
        if( instance == null ) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    public static DatabaseHelper getDatabaseInstance(){
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_FOOD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD);

        //then restart db
        onCreate(db);
    }


    public void insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASSWORD, user.getPassword());
        values.put(COLUMN_FRIDGE_ID, user.getFridge().getId());

        // insert row
        db.insert(TABLE_USER, null, values);
    }

    public boolean checkValidUsername(User user) {
        /**
         * return false if the username is already used
         * return true if the username is free
         */
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_USER + " WHERE " +  COLUMN_USERNAME + " = '" + user.getUsername() + "'";

        Log.e(String.valueOf(LOG), selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) return false;
        else return true;
    }

    public boolean checkFridgeId(Fridge fridge) {
        /**
         * return true if the id is not used
         * return false else
         */
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_FRIDGE_ID  + " = '" + fridge.getId() + "'";

        Log.e(String.valueOf(LOG), selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) return false;
        else return true;

    }

    public boolean checkValidUser(User user) {
        /**
         * return true if the username and password match
         * return false if the  username and password don't match
         */
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_USERNAME + " = '" + user.getUsername() + "' AND " + COLUMN_PASSWORD + " = '" + user.getPassword() + "'";

        Log.e(String.valueOf(LOG), selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        return c.moveToFirst();
    }

}
