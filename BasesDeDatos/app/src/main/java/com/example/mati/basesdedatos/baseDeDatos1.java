package com.example.mati.basesdedatos;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class baseDeDatos1 extends AppCompatActivity {
    SQLiteDatabase db;
    static class ViewHolder{
        TextView nombre;
        TextView telefono;
    }
    Cliente datos[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_de_datos1);

        com.example.mati.basesdedatos.ClienteSQLiteHelper cliBDh=new
                com.example.mati.basesdedatos.ClienteSQLiteHelper(this, "DBClientes", null, 1);
        db=cliBDh.getReadableDatabase();
        tratarRegistros();

        final Spinner spi=(Spinner)findViewById(R.id.spiner);
        AdaptadorCliente adap=new AdaptadorCliente(this);
        spi.setAdapter(adap);

        final Button botonAñadir=(Button) findViewById(R.id.añadirbtn);
        botonAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.ingresar_boton);
            }
        });

        final Button btnOk=(Button)findViewById(R.id.buttonOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadirDatos(db);
            }
        });
    }

    public void tratarRegistros(){
        String[] campos=new String[]{"nombre", "telefono"};

        String codSQL="CREATE TABLE IF NOT EXISTS Clientes (codigo INTEGER, nombre TEXT, telefono TEXT)";
        db.execSQL(codSQL);
        for(int i=1;i<=3; i++)
        {
            int codigo=i;
            String nombre="AAA"+i;
            String telefono=i+"XXXXXXX";

            db.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
            "VALUES (" + codigo + ", '"+nombre+"', '"+telefono+"')");
        }

        Cursor c=db.query("Clientes", campos, null, null, null, null, null);
        datos=new Cliente[c.getCount()];
        int i=0;
        if(c.moveToFirst())
        {
            do{
                String nombreCli=c.getString(0);
                String telefonoCli=c.getString(1);

                datos[i]=new Cliente(nombreCli, telefonoCli);
                i++;
            } while(c.moveToNext());
        }
    }

    public void añadirDatos(SQLiteDatabase db)
    {
        int codigo;
        String nombre, telefono;
        Cursor cursor=db.rawQuery("SELECT * Cliente", null);
        int numero=cursor.getCount();

        codigo=numero+1;
        nombre=findViewById(R.id.ingresaNom).toString();
        telefono=findViewById(R.id.ingresaTlf).toString();

        db.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
        "VALUES ("+codigo+", '"+nombre+"', '"+telefono+"')");
    }

    class AdaptadorCliente extends ArrayAdapter{
        Activity context;
        @SuppressWarnings("unchecked")
        public AdaptadorCliente(Activity context){
            super(context, R.layout.downspiner, datos);
            this.context=context;
        }
        public View getDropDownView(int posicion, View convertView, ViewGroup parent){
            return getView(posicion, convertView, parent);
        }
        public View getView(int posicion, View convertView, ViewGroup parent){
            View item=convertView;
            ViewHolder holder;
            if(item==null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.downspiner, null);
                holder=new ViewHolder();
                holder.nombre=(TextView)item.findViewById(R.id.nombre);
                holder.telefono=(TextView)item.findViewById(R.id.tlf);
                item.setTag(holder);
            } else
                holder=(ViewHolder)item.getTag();
            holder.nombre.setText(datos[posicion].getNombre());
            holder.telefono.setText(datos[posicion].getTlf());
            return item;
        }
    }

}
