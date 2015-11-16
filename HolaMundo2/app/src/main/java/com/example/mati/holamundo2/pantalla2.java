package com.example.mati.holamundo2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mati on 5/10/15.
 */
public class pantalla2 extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2);
        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);
        final ImageButton btnImage= (ImageButton)findViewById(R.id.btnImage);
        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));
        btnImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(pantalla2.this, Hola2.class);
                startActivity(miIntent);
            }
        });
        showToast("Estas en la pantalla 2");
    }

    protected void showToast(CharSequence text)
    {
        Context context= getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

        @Override
        protected void onStart()
        {
            super.onStart();
            Toast.makeText(this, "onStart-PantallaSecundaria", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onResume()
        {
            super.onResume();
            Toast.makeText(this,"onResume-PantallaSecundaria", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPause()
        {
            Toast.makeText(this,"onPause-PantallaSecundaria", Toast.LENGTH_SHORT).show();
            super.onPause();
        }

        @Override
        protected void onStop()
        {
            super.onStop();
            Toast.makeText(this,"onStop-PantallaSecundaria", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onRestart()
        {
            super.onRestart();
            Toast.makeText(this,"onRestart-PantallaSecundaria", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onDestroy()
        {
            Toast.makeText(this,"onDestroy-PantallaSecundaria", Toast.LENGTH_SHORT).show();
            super.onDestroy();
        }

    }

