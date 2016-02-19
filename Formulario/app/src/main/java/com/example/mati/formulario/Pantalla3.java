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

        listar.setLongClickable(true);
        registerForContextMenu(listar);
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
            super(activity,R.layout.items, destino);
            main=activity;
        }

        @Override
        public View getView(int posicion, View convertView, ViewGroup parent)
        {
            LayoutInflater inflate = getLayoutInflater();
            convertView=inflate.inflate(R.layout.items, null);

            zona=destino[posicion].getZona();
            continente=destino[posicion].getContinente();
            precio=Double.parseDouble(destino[posicion].getPrecio());
            imagen=destino[posicion].getImagen();

            TextView Zone=(TextView) convertView.findViewById(R.id.zona3);
            Zone.setText(zona);
            TextView Continent=(TextView)convertView.findViewById(R.id.continente3);
            Continent.setText(continente);
            TextView Prize=(TextView) convertView.findViewById(R.id.precio3);
            Prize.setText(String.valueOf(precio));
            ImageView Image=(ImageView)convertView.findViewById(R.id.Imagen3);
            Image.setImageResource(imagen);

            return convertView;
        }
    }

}
