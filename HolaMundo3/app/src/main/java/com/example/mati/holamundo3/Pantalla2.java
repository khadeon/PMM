package com.example.mati.holamundo3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class Pantalla2 extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2);
        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);
        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));

    }
}
