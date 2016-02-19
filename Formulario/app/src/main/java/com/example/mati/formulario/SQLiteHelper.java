package com.example.mati.formulario;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


public class SQLiteHelper extends SQLiteOpenHelper{
    String comandoTablaDestino = "CREATE TABLE Destino (id INTEGER PRIMARY KEY, zona TEXT,continente TEXT, imagen INTEGER, precio TEXT )";
    String comandoTablaUsuario = "CREATE TABLE Usuarios (id INTEGER PRIMARY KEY, usuario TEXT, contraseña TEXT)";
    String comandoListarDestinos = "SELECT * FROM Destino";
    String comandoListarUsuarios = "SELECT * FROM Usuarios";

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void InsertarDatosDestino(SQLiteDatabase db, Context contexto, Destino destino)
    {
        if(db != null)
        {
            Log.d("datos", "" + destino.getZona() + destino.getContinente() + destino.getPrecio() + destino.getImagen());
            Toast.makeText(contexto, ""+destino.getZona()+destino.getContinente()+destino.getPrecio()+destino.getImagen(), Toast.LENGTH_SHORT).show();
            String query = "INSERT INTO Destino (zona, continente, imagen, precio) VALUES ('" + destino.getZona() + "', '"+destino.getContinente()+"', '"+destino.getImagen()+"', '"+destino.getPrecio()+"');";
            Log.d("query",query);
            db.execSQL(query);
            db.close();
            Log.d("probando", "todo correcto");

        }
        else
        {
            Toast.makeText(contexto, "Error de conexión", Toast.LENGTH_SHORT).show();
        }
    }

    public void InsertarDatosUsuarios(SQLiteDatabase db, Context contexto, Usuarios usuario)
    {
        if(db != null)
        {
            db.execSQL("INSERT INTO Usuarios (usuario, contraseña) "+
            "VALUES ('" + usuario.getUsuario() + "', '" + usuario.getContraseña() +"')");
            db.close();
            Log.d("segunda prueba", "todo bien");
        }
        else
        {
            Toast.makeText(contexto, "Error de conexión", Toast.LENGTH_SHORT).show();
        }
    }

    public Destino[] ListarDestino(SQLiteDatabase db)
    {
        Destino objetoAux;

        Cursor cursor = db.rawQuery(comandoListarDestinos, null);
        Log.d("PRUEBACOLUMNA",String.valueOf(cursor.getColumnCount()));
        cursor.moveToFirst();
        Log.d("Losgets", cursor.getString(1));
        Log.d("CURSORPRUEBA",String.valueOf(cursor.getCount()));

        Destino[] dest = new Destino[cursor.getCount()];
        int cont = 0;
        do
        {
            objetoAux = new Destino(cursor.getString(1),cursor.getString(2),cursor.getString(4),cursor.getInt(3));
            dest[cont] = objetoAux;
            cont++;
        }
        while(cursor.moveToNext());
        cursor.close();
        db.close();

        return dest;
    }

    public Usuarios[] ListarUsuarios(SQLiteDatabase db)
    {
        Usuarios objetoAux;
        Cursor cursor = db.rawQuery(comandoListarUsuarios, null);
        cursor.moveToFirst();
        Usuarios[] usu = new Usuarios[cursor.getCount()];
        int cont = 0;
        do {
            objetoAux = new Usuarios(cursor.getString(1), cursor.getString(2));
            usu[cont] = objetoAux;
            cont++;
        }
        while(cursor.moveToNext());
        cursor.close();
        db.close();

        return usu;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(comandoTablaDestino);
        db.execSQL(comandoTablaUsuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Destino");
        db.execSQL(comandoTablaDestino);
    }
}
