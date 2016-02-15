package com.example.mati.formulario;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Dibujar extends AppCompatActivity {

    private static Dibujo dibu;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dibujo_azafata);

        dibu=(Dibujo)findViewById(R.id.areaDibujo);
    }
}
