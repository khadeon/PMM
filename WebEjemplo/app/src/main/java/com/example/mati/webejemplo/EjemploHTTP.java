package com.example.mati.webejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EjemploHTTP extends AppCompatActivity {

    private Button boton;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_http);
        boton=(Button)findViewById(R.id.Boton1);
        texto=(TextView)findViewById(R.id.texto1);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String noticias=buscarNoticias();
                    texto.append(noticias);
                } catch(Exception e){
                    texto.append("Error al conectar");
                    e.printStackTrace();
                }
            }
        });
    }

    private String buscarNoticias() throws Exception{
        String salida="";
        int i=0, j=0;

        URL url =new URL("http://www.elpais.com/rss/feed.html?feedId=1022");

        HttpURLConnection conexion=(HttpURLConnection) url.openConnection();

        conexion.setRequestProperty("User-Agent","Mozilla/5.0"+" (Linux; Android 1.5; es-ES) Ejemplo HTTP");


        if(conexion.getResponseCode()==HttpURLConnection.HTTP_OK){
            BufferedReader lector=new BufferedReader(
                    new InputStreamReader(conexion.getInputStream())
            );
            String linea=lector.readLine();
            while(linea!=null)
            {
                if(linea.indexOf("<title>") >=0){
                    i=linea.indexOf("<title>")+16;
                    j=linea.indexOf("<title>")-3;
                    salida+=linea.substring(i,j);
                    salida+="\n-------------------------\n";
                }
                linea=lector.readLine();
            }
            lector.close();
        }
        else{
            salida="No encontrado";
        }
        conexion.disconnect();;
        return salida;
    }

}
