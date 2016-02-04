package com.example.mati.bicijuego;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SoloBici extends AppCompatActivity {

    private Button BJuego =(Button) findViewById(R.id.botonJuego);
    private Button BAcerca =  (Button) findViewById(R.id.botonAcerca);
    private Button BPreferencia = (Button) findViewById(R.id.botonPreferencias);
    private Button BSalir = (Button) findViewById(R.id.botonSalir);


    public class Juego extends Activity {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_solo_bici);
            BJuego.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startJuego();
                }
            });
            BPreferencia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startPreferencias();
                }
            });
            BAcerca.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startAcerca();
                }
            });
            BSalir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.exit(0);
                }
            });
        }
    }

    private void startJuego()
    {
        Juego juego=new Juego();
    }
    private void startPreferencias()
    {
        Preferencias preferencias=new Preferencias();
    }
    private void startAcerca()
    {
        AcercaDe acerca=new AcercaDe();
    }
    private void startVistaJuego()
    {
        Context context = null;
        AttributeSet attributeSet = null;
        VistaJuego vista=new VistaJuego(context, attributeSet);
    }
}
