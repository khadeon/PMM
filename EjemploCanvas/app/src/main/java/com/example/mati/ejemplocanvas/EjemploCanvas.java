package com.example.mati.ejemplocanvas;

import android.os.Bundle;
import android.app.Activity;


public class EjemploCanvas extends Activity {

    private static EjemploView dibujo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_canvas);
        dibujo=(EjemploView)findViewById(R.id.areaDibujo);
    }

}
