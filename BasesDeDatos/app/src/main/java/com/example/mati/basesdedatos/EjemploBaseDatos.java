package com.example.mati.basesdedatos;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

/**
 * Created by mati on 18/01/16.
 */
public class EjemploBaseDatos extends Activity {
    public void OnCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_de_datos1);

        ClienteSQLiteHelper cliBDH=new ClienteSQLiteHelper(this, "DBClientes", null, 1);

        SQLiteDatabase bd=cliBDH.getWritableDatabase();
        if(bd!=null)
        {
            for(int i=1;i<=3;i++)
            {
                int codigo=i;
                String nombre="Cliente"+i;
                String telefono=i+"XXXXXXX";
                //introducir datos en BD
                bd.execSQL("INSERT INTO Clientes(codigo, nombre, telefono) "+
                        "VALUES ("+codigo+", '"+ nombre + "', '"+ telefono +"')");
                bd.close();
            }
        }
    }
}
