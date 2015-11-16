package com.example.mati.ibenavente;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends Activity {

    public Spinner miSpinner;
    private Pizza[] pizzas=new Pizza[]{
            new Pizza("MARGARITA", "jamon/tomate", 13, R.drawable.pizza1),
            new Pizza("3 QUESOS", "queso1/queso2", 15, R.drawable.pizza2),
            new Pizza("MARGARITA", "carne/tomate", 17, R.drawable.pizza3)
    };

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button miBoton= (Button)findViewById(R.id.button);

        final EditText unidades=(EditText)findViewById(R.id.editText);

        int aux=R.id.editText2;
        miSpinner=(Spinner) findViewById(R.id.spinner);
        AdaptadorPizza adaptador=new AdaptadorPizza(this);
        miSpinner.setAdapter(adaptador);
        miSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                aux=pizzas[position].getPrecio();
            }
        });



    }

    class AdaptadorPizza extends ArrayAdapter<Pizza>
    {

        public Activity miActividad;
        MainActivity actPrincipal;
        public AdaptadorPizza(Activity act){
            super(act, R.layout.spinner_menu, pizzas);
            this.miActividad=act;
        }
        public View getDropDownView(int posicion, View ver, ViewGroup parent) {
            View vistaDesplegada = getView(posicion, ver, parent);
            return vistaDesplegada;
        }
        public View getView(int posicion, View ver, ViewGroup parent){
            LayoutInflater inflar=miActividad.getLayoutInflater();
            View item = inflar.inflate(R.layout.spinner_menu, null);

            TextView eNombre=(TextView)item.findViewById(R.id.Nombre);
            TextView eIngrediente=(TextView)item.findViewById(R.id.Ingrediente);
            TextView ePrecio=(TextView)item.findViewById(R.id.precio);
            ImageView eImagen=(ImageView)item.findViewById(R.id.Imagen);

            eNombre.setText(pizzas[posicion].getNombre());
            eIngrediente.setText(pizzas[posicion].getIngrediente());
            ePrecio.setText(Double.toString(pizzas[posicion].getPrecio()));
            eImagen.setImageResource(pizzas[posicion].getImagen());

            return item;
        }

    }

}

