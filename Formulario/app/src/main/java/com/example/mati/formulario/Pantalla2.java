package com.example.mati.formulario;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    SQLiteHelper helper;
    SQLiteDatabase db;
    Destino destino;
    Context contexto;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2);
        contexto = this;
        MainActivity objeto=new MainActivity();
        objeto.precioPlus=0.0;

        final TextView zona=(TextView)findViewById(R.id.zona2);
        final TextView continente=(TextView)findViewById(R.id.continente2);
        final TextView precio=(TextView)findViewById(R.id.precio2);
        final TextView precioplus=(TextView)findViewById(R.id.precioplus2);
        final TextView cantidad=(TextView)findViewById(R.id.cantidad2);
        final TextView precioFinal=(TextView)findViewById(R.id.precioFinal2);
        final TextView importancia=(TextView)findViewById(R.id.importancia2);
        final ImageView imagen=(ImageView)findViewById(R.id.imagen2);

        final TextView viewUsuario = (TextView)findViewById(R.id.tusuario);

        Bundle bundle=getIntent().getExtras();
        String cadZona=bundle.getString("Zona");
        String cadContinente=bundle.getString("Continente");
        Double cadPrecio=bundle.getDouble("Precio");
        Double cadPrecioplus=bundle.getDouble("PrecioPlus");
        int cadCantidad=bundle.getInt("Cantidad");
        Double cadPrecioFinal=bundle.getDouble("Precio final");
        String cadImportancia=bundle.getString("Clase de envio");
        int cadImagen=bundle.getInt("Imagen");

        String usuario = bundle.getString("Usuario");

        zona.setText("Zona: "+cadZona);
        continente.setText("Continente: "+cadContinente);
        precio.setText(String.valueOf("Precio: "+cadPrecio));
        precioplus.setText(String.valueOf("Precio añadido: "+cadPrecioplus));
        cantidad.setText(String.valueOf("Cantidad: " + cadCantidad));
        precioFinal.setText(String.valueOf("Precio final: " + cadPrecioFinal));
        importancia.setText("Clase de envio: " + cadImportancia);
        imagen.setImageResource(cadImagen);

        viewUsuario.setText(usuario);

        Button cargar = (Button)findViewById(R.id.Registrar);
        destino = new Destino(cadZona, cadContinente, ""+cadPrecioFinal, cadImagen);
        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helper = new SQLiteHelper(Pantalla2.this, "DBUsuarios", null, 1);
                db = helper.getWritableDatabase();
                helper.InsertarDatosDestino(db, contexto, destino);


            }
        });
        Button ver = (Button)findViewById(R.id.Visualizar);
        ver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pantalla3.class);
                startActivity(intent);
            }
        });

        if(usuario.equals("Anonimo")){
            cargar.setVisibility(View.INVISIBLE);
            ver.setVisibility(View.INVISIBLE);
        }

    }


}
