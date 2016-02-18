package com.example.mati.formulario;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Pantalla3 extends Activity{
    Destino [] destino;
    String zona, continente;
    double precio;
    int imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patanlla3);

        destino = listarDatos(this);

        ListView listar=(ListView)findViewById(R.id.listado);
        ListAdapter adapter = new ListAdapter(this);
        listar.setAdapter(adapter);
    }

    public Destino[] listarDatos(Context context)
    {
        SQLiteHelper dbHelper=new SQLiteHelper(context, "DBUsuarios", null, 1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return dbHelper.ListarDestino(db);
    }

    public class ListAdapter extends ArrayAdapter
    {
        Activity main;
        public ListAdapter(Activity activity)
        {
            super(activity,R.layout.spinner_item, destino);
            main=activity;
        }

        @Override
        public View getView(int posicion, View convertView, ViewGroup parent)
        {
            LayoutInflater inflate = getLayoutInflater();
            convertView=inflate.inflate(R.layout.spinner_item, null);

            TextView Zone=(TextView) convertView.findViewById(R.id.zona3);
            Zone.setText(destino[posicion].getZona());
            TextView Continent=(TextView)convertView.findViewById(R.id.continente3);
            Continent.setText(destino[posicion].getContinente());
            ImageView Image=(ImageView)convertView.findViewById(R.id.Imagen3);
            Image.setImageResource(destino[posicion].getImagen());
            TextView Prize=(TextView)convertView.findViewById(R.id.precio3);
            Prize.setText(destino[posicion].getPrecio());

            zona=destino[posicion].getZona();
            continente=destino[posicion].getContinente();
            imagen=destino[posicion].getImagen();
            precio=Double.parseDouble(destino[posicion].getPrecio());

            return convertView;
        }
    }

}
