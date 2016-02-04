package com.example.mati.basesdedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mati on 18/01/16.
 */
public class ClienteSQLiteHelper extends SQLiteOpenHelper {
    String codSQL="CREATE TABLE Clientes(codigo INTEGER, nombre TEXT, telefono TEXT)";
    public ClienteSQLiteHelper(Context contexto, String nombre, CursorFactory almacen, int version)
    {
        super(contexto,nombre,almacen,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(codSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS Clientes");
        db.execSQL(codSQL);
    }

}
