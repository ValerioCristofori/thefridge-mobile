package it.valeriocristofori.thefridgemobile.db.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import it.valeriocristofori.thefridgemobile.model.entity.Food;
import it.valeriocristofori.thefridgemobile.model.entity.Fridge;

public class DaoFood {
    /*private DatabaseManagerConnection conn;
    private SQLiteDatabase db;

    public DaoFood() throws Exception {
        this.conn = DatabaseManagerConnection.getSingletonInstance();
        this.conn.open();
        this.db = this.conn.getDb();
    }


    public void insertFood( Fridge fridge, Food food){
        ContentValues values = new ContentValues();
        values.put("name", food.getName() );
        values.put("expirationDate", food.getExpirationDate() );
        values.put("quantity", food.getQuantity() );
        values.put("id", fridge.getId() );

        // insert row
        db.insert("Food", null, values);
    }
*/
}
