package it.valeriocristofori.thefridgemobile.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Random;

import it.valeriocristofori.thefridgemobile.db.init.DatabaseManagerConnection;
import it.valeriocristofori.thefridgemobile.model.entity.User;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class DaoUser {
    private DatabaseManagerConnection conn;
    private SQLiteDatabase db;

    public DaoUser() throws Exception {
        this.conn = DatabaseManagerConnection.getSingletonInstance();
        this.conn.open();
        this.db = this.conn.getDb();
    }

    public void insertUser( User user ){
        ContentValues values = new ContentValues();
        values.put("username", user.getUsername());
        values.put("emailAddress", user.getEmail());
        values.put("password", user.getPassword());
        values.put("id", create_id() );

        // insert row
        long todo_id = db.insert("User", null, values);
    }

    public boolean checkValidUsername( User user ){
        /**
         * return true if the username is already used
         * return false if the username is free
         */

        String selectQuery = "SELECT * FROM User WHERE username = " + user.getUsername();

        Log.e(String.valueOf(LOG), selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        return c.moveToFirst();
    }

    public boolean checkValidUser( User user , String password){
        /**
         * return true if the username and password match
         * return false if the  username and password don't match
         */

        String selectQuery = "SELECT * FROM User WHERE username = " + user.getUsername() + " AND password = " + password;

        Log.e(String.valueOf(LOG), selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        return c.moveToFirst();
    }


    private int create_id(){
        //choose random fridge's id from 1 to 10 000
        Random rand = new Random();
        int id = rand.nextInt(10000);
        //check if exist : throw exception ? null

        return id;
    }


}
