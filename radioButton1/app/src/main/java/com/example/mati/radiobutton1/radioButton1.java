package com.example.mati.radiobutton1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;


    public class radioButton1 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_radio_button1);


            final TextView lblMensaje = (TextView) findViewById(R.id.LblSeleccion);
            final RadioGroup rg = (RadioGroup) findViewById(R.id.gruporb);
            rg.clearCheck();

            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    //lblMensaje.setText("Opcion seleccionada: " + checkedId);

                String textoOpcion="";
                if( group.getCheckedRadioButtonId()==R.id.radio1)
                    textoOpcion="Opcion 1";
                if( group.getCheckedRadioButtonId()==R.id.radio2)
                    textoOpcion="Opcion 2";

                lblMensaje.setText("La opcion seleccionada es: "+textoOpcion);

                }
            });

        }

    }
