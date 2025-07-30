package com.example.parcial_numero_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "LISTA_COMPRAS_RELOJES";
    private static final String TABLE_NAME = "RELOJES";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "MODELO";
    private static final String COL_3 = "MARCA";
    private static final String COL_4 = "DESCRIPCION";
    private static final String COL_5 = "PRECIO";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE_NAME+
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "MODELO TEXT," +
                "MARCA TEXT," +
                "DESCRIPCION TEXT," +
                "PRECIO TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertValues(String modelo, String marca){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, modelo);
        values.put(COL_3, marca);

        long var = db.insert(TABLE_NAME, null, values);
        if (var == -1){
            return false;
        }else{
            return true;
        }
    }

}
