package com.example.parcial_numero_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/*
 Falta agregar una tabla para las imágenes y listo.
 Opcional: Que permita varias imágenes
 */
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

    public boolean insertValues(String modelo, String marca, String descr, String precio){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, modelo);
        values.put(COL_3, marca);
        values.put(COL_4, descr);
        values.put(COL_5, precio);

        long var = db.insert(TABLE_NAME, null, values);
        if (var == -1){
            return false;
        }else{
            return true;
        }
    }

    public List<ClaseReloj> getAll() { //Borrar comentarios
        // 1. Preparamos la lista vacía
        List<ClaseReloj> lista = new ArrayList<>();

        // 2. Abrimos la base en modo lectura
        SQLiteDatabase db = this.getReadableDatabase();

        // 3. Ejecutamos la consulta
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // 4. Recorremos fila a fila
        while (cursor.moveToNext()) {
            // Por posición: 0=ID, 1=MODELO, 2=MARCA, 3=DESCRIPCION, 4=PRECIO
            int id        = cursor.getInt(0);
            String modelo = cursor.getString(1);
            String marca  = cursor.getString(2);
            String descr  = cursor.getString(3);
            String precio = cursor.getString(4);

            // Creamos el objeto y lo añadimos
            lista.add(new ClaseReloj(id, modelo, marca, descr, precio));
        }

        // 5. Cerramos el cursor
        cursor.close();

        // 6. Devolvemos la lista completa
        return lista;
    }

}
