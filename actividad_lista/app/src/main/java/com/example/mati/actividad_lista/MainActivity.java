package com.example.mati.actividad_lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //ListView lista;
    Spinner miSpinner;
    final static String opciones[]={"Opcion1", "Opcion2", "Opcion3", "Opcion4"};

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mensaje;
        //lista=(ListView) findViewById(R.id.listView);
        miSpinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, opciones);
        //lista.setAdapter(adaptador);
        adaptador.setDropDownViewResource(android.R.layout.simple_list_item_1);
        miSpinner.setAdapter(adaptador);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Has elegido la " + opciones[position];
                showToast(mensaje);
            }

            public void onNothingSelected(AdapterView<?> adapterView){}
        });
    }
    public void showToast(String text)
    {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
