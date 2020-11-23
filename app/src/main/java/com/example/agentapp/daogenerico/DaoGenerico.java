package com.example.agentapp.daogenerico;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class DaoGenerico {

    Context MyContext;
    DriverDB MyDriverDB;
    SQLiteDatabase MySQLiteDatabase;

    public DaoGenerico(Context myContext) {
        MyContext = myContext;
        MyDriverDB = new DriverDB(myContext);
        MySQLiteDatabase = MyDriverDB.getReadableDatabase();
    }

    public SQLiteDatabase getConnection() {

        if (MySQLiteDatabase != null) {

            return (MySQLiteDatabase);

        } else {

            MySQLiteDatabase = MyDriverDB.getWritableDatabase();
            return (MySQLiteDatabase);

        }

    }

    public boolean CloseConnection() {

        if (MySQLiteDatabase != null) {

            MySQLiteDatabase.close();
            MySQLiteDatabase = null;
            return true;
        } else {

            return false;

        }

    }
}
