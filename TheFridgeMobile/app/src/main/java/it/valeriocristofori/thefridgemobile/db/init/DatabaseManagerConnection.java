package it.valeriocristofori.thefridgemobile.db.init;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

public class DatabaseManagerConnection {
    private static DatabaseManagerConnection instance = null;
    private final Context context;
    private DatabaseHelper DBHelper;

    public SQLiteDatabase getDb() {
        return db;
    }

    private SQLiteDatabase db;

    private DatabaseManagerConnection(Context context){
        this.context = context;
        DBHelper = new DatabaseHelper(context);
    }

    public DatabaseManagerConnection open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }


    public void close()
    {
        DBHelper.close();
    }

    public static DatabaseManagerConnection getSingletonInstance(Context context){
        if( instance == null ){
            instance = new DatabaseManagerConnection(context);
        }
        return instance;
    }

    public static DatabaseManagerConnection getSingletonInstance() throws Exception {
        if( instance == null ){
            throw new Exception();
        }
        return instance;
    }

}
