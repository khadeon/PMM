package com.example.mati.holamundo2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Hola2 extends Activity {
    public MediaPlayer miMusica;
    public int posicion;
    public static int COD_RESPUESTA=0;
    TextView elSaludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola2);
        final EditText miTexto= (EditText)findViewById(R.id.miTxt);
        final Button miBoton= (Button)findViewById(R.id.miBtn);
        elSaludo= (TextView)findViewById(R.id.miLbl);
        //Musica introducida en la carpeta raw
        miMusica=MediaPlayer.create(getApplicationContext(),R.raw.forestfire);

        miTexto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                miTexto.setText("");
            }
        });
        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(Hola2.this, pantalla2.class);
                Bundle miBundle = new Bundle();
                String mensajePaso = "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });
        showToast("Estas en la pantalla 1");
    }

    protected void showToast(CharSequence text)
    {
        Context context= getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    protected void showAlert(CharSequence text)
    {
        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        alert.setMessage(text);
        alert.setPositiveButton(android.R.string.ok, null);
        alert.show();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(this,"onStart-PantallaPrincipal", Toast.LENGTH_SHORT).show();
        miMusica.start();
        miMusica.seekTo(posicion);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(this,"onResume-PantallaPrincipal", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause()
    {
        Toast.makeText(this,"onPause-PantallaPrincipal", Toast.LENGTH_SHORT).show();
        super.onPause();
        posicion=miMusica.getCurrentPosition();
        miMusica.pause();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(this,"onStop-PantallaPrincipal", Toast.LENGTH_SHORT).show();
    }
/*
    @Override
    protected void onRestart()
    {
        super.onRestart();
        Toast.makeText(this,"onRestart-PantallaPrincipal", Toast.LENGTH_SHORT).show();
    }
*/
    @Override
    protected void onDestroy()
    {
        Toast.makeText(this,"onDestroy-PantallaPrincipal", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

}