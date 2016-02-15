package com.example.mati.formulario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteHelper extends SQLiteOpenHelper{
    String crearTabla="CREATE TABLE IF NOT EXISTS Usuarios (usuario TEXT, contraseña TEXT)";

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
