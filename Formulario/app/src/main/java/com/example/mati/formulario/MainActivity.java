package com.example.mati.formulario;

import android.app.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    CheckBox EdLimitada, EdEspecial;
    EditText cantidad;
    Spinner spinner;
    RadioGroup radioGrupo;
    Button calculo;

    String zone;
    String continent;
    Double price;
    int image;

    Double precioPlus=0.0;

    String Importancia;
    String Envio;

    private Destino[] itemSpinner=new Destino[]{
            new Destino("A","Asia-Oceania","30",R.drawable.asia),
            new Destino("B","America-Africa","20",R.drawable.america),
            new Destino("C","Europa","10",R.drawable.europa)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AlertDialog.Builder(this)

            .setTitle("Identificación")
                .setMessage("Por favor elija si quiere entrar con anonimo o como usuarion registrado")
                .setPositiveButton("Registrarse", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intento2 = new Intent(MainActivity.this, Registro.class);
                        startActivity(intento2);
                    }
                })
                .setNegativeButton("Anonimo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Iniciado como Anonimo", Toast.LENGTH_SHORT).show();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();


        EdLimitada=(CheckBox)findViewById(R.id.EdLimitada);
        EdEspecial=(CheckBox)findViewById(R.id.EdEspecial);

        cantidad=(EditText)findViewById(R.id.cantidad);
        Adapter adapter=new Adapter(this);
        spinner=(Spinner)findViewById(R.id.spiner);
        spinner.setAdapter(adapter);
        radioGrupo=(RadioGroup)findViewById(R.id.GRadio);
        radioGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(R.id.eNormal==radioGrupo.getCheckedRadioButtonId())
                {
                    Importancia = "Envio normal";
                }
                else{
                    Importancia="Envio en 24h";
                    precioPlus=precioPlus+(price*30)/100;
                }
            }
        });
        EdLimitada.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(EdLimitada.isChecked())
                {
                    Envio="Edicion Limitada";
                    precioPlus=precioPlus+2;
                } else{
                    Envio="Nada";
                }
            }
        });
        EdEspecial.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(EdEspecial.isChecked())
                {
                    Envio="Edicion Especial";
                    precioPlus=precioPlus+1;
                }else{
                    Envio="Nada";
                }
            }
        });
        calculo=(Button)findViewById(R.id.btnCalcu);
        calculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cantidad.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Inserte cantidad a enviar", Toast.LENGTH_SHORT).show();
                }
                else{
                    int canti=Integer.parseInt(cantidad.getText().toString());
                    if(canti<=5){
                        precioPlus=precioPlus+canti;
                    }
                    if(canti>=6 || canti<10){
                        precioPlus=precioPlus+canti*1.5;
                    }
                    if(canti>10){
                        precioPlus=precioPlus+canti*2;
                    }

                    Intent intent=new Intent(MainActivity.this, Pantalla2.class);
                    Bundle bundle=new Bundle();

                    Log.d("prueba", zone);

                    bundle.putString("Zona", zone);
                    bundle.putString("Continente", continent);
                    bundle.putDouble("Precio", price);
                    bundle.putDouble("PrecioPlus", precioPlus);
                    bundle.putInt("Cantidad", canti);
                    bundle.putDouble("Precio final", price+precioPlus);
                    bundle.putString("Clase de envio", Importancia);
                    bundle.putInt("Imagen", image);

                    intent.putExtras(bundle);

                    startActivity(intent);
                }
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menu)
    {
        switch(menu.getItemId()){
            case R.id.menu1:
                Intent activityIntent = new Intent(this, Dibujar.class);
                startActivity(activityIntent);
                return true;
            case R.id.menu2:
                Toast.makeText(getApplicationContext(),"Version 1.0 \n Copyright sin aplicar \n Israel Benavente Lopez", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(menu);
        }
    }

    class Adapter extends ArrayAdapter<Destino>{
        Activity context;

        Adapter(Activity context){
            super(context,R.layout.spinner_item,itemSpinner);
            this.context=context;
        }

        public View getDropDownView(int position,View converView, ViewGroup parent){
            return getView(position, converView,parent);
        }
        public View getView(int position,View converView, ViewGroup parent){
            LayoutInflater inflater=getLayoutInflater();
            converView=inflater.inflate(R.layout.spinner_item, null);
            TextView zona=(TextView)converView.findViewById(R.id.zona);
            zona.setText(itemSpinner[position].getZona());
            TextView continente=(TextView)converView.findViewById(R.id.continente);
            continente.setText(itemSpinner[position].getContinente());
            TextView precio=(TextView)converView.findViewById(R.id.precio);
            precio.setText(itemSpinner[position].getPrecio());
            ImageView imagen=(ImageView)converView.findViewById(R.id.ivImagen);
            imagen.setImageResource(itemSpinner[position].getImagen());

            zone=itemSpinner[position].getZona();
            continent=itemSpinner[position].getContinente();
            price=Double.parseDouble(itemSpinner[position].getPrecio());
            image=itemSpinner[position].getImagen();

            return converView;
        }

    }
}
