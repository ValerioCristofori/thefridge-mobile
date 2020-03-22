package it.valeriocristofori.thefridgemobile.db.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import it.valeriocristofori.thefridgemobile.db.init.DatabaseManagerConnection;
import it.valeriocristofori.thefridgemobile.model.entity.User;

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

    private int create_id(){
        //choose random fridge's id from 1 to 10 000
        int id = 0;


        return id;
    }

}
