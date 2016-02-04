package com.example.mati.formulario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2);

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

        Bundle bundle=getIntent().getExtras();
        String cadZona=bundle.getString("Zona");
        String cadContinente=bundle.getString("Continente");
        Double cadPrecio=bundle.getDouble("Precio");
        Double cadPrecioplus=bundle.getDouble("PrecioPlus");
        int cadCantidad=bundle.getInt("Cantidad");
        Double cadPrecioFinal=bundle.getDouble("Precio final");
        String cadImportancia=bundle.getString("Clase de envio");
        int cadImagen=bundle.getInt("Imagen");

        zona.setText("Zona: "+cadZona);
        continente.setText("Continente: "+cadContinente);
        precio.setText(String.valueOf("Precio: "+cadPrecio));
        precioplus.setText(String.valueOf("Precio añadido: "+cadPrecioplus));
        cantidad.setText(String.valueOf("Cantidad: "+cadCantidad));
        precioFinal.setText(String.valueOf("Precio final: "+cadPrecioFinal));
        importancia.setText("Clase de envio: "+cadImportancia);
        imagen.setImageResource(cadImagen);
    }


}
