package com.example.mati.formulario;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity
{
    SQLiteDatabase db;
    SQLiteHelper dbHelper;

    Button botonAcceder, botonRegistrando;

    String usuario, contraseña;

    EditText usuarioEdit;
    EditText contraseñaEdit;

    TextView error1;
    TextView error2;

    Context contexto;

    Usuarios usuarios;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_usuario);

        usuarioEdit=(EditText)findViewById(R.id.textoUsuario);
        contraseñaEdit=(EditText)findViewById(R.id.textoContraeña);

        error1=(TextView)findViewById(R.id.mensajeError1);
        error2=(TextView)findViewById(R.id.MensajeError2);

        botonAcceder=(Button)findViewById(R.id.botonEntrar);
        botonRegistrando=(Button)findViewById(R.id.botonRegistro);

        botonRegistrando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuario = usuarioEdit.getText().toString();
                contraseña = contraseñaEdit.getText().toString();

                if(usuario != null && contraseña != null)
                {
                    usuarios = new Usuarios(usuario, contraseña);
                    dbHelper = new SQLiteHelper(Registro.this, "DBUsuarios", null, 1);

                    db = dbHelper.getWritableDatabase();
                    dbHelper.InsertarDatosUsuarios(db, Registro.this, usuarios);
                    dbHelper.close();
                    db.close();
                }
            }
        });

        botonAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuario = usuarioEdit.getText().toString();
                contraseña = contraseñaEdit.getText().toString();

                if(usuario != null && contraseña != null)
                {
                    Usuarios newUsuario=new Usuarios(usuario, contraseña);

                    dbHelper = new SQLiteHelper(Registro.this, "DBUsuarios", null, 1);
                    db = dbHelper.getReadableDatabase();

                    Usuarios[] vectorUsuarios =dbHelper.ListarUsuarios(db);

                    for(int i=0; i<vectorUsuarios.length; i++)
                    {
                        if(newUsuario.getUsuario().equals(vectorUsuarios[i].getUsuario()) && newUsuario.getContraseña().equals(vectorUsuarios[i].getContraseña()))
                        {
                            Toast.makeText(Registro.this, "Sesion iniciada como usuario "+newUsuario.getUsuario()+". Volviendo a la pantalla 1", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            String usur = vectorUsuarios[i].getUsuario();
                            Bundle bundle = new Bundle();
                            bundle.putString("Usuario", usur);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    }
                    error1.setVisibility(View.VISIBLE);
                    dbHelper.close();
                    db.close();
                }
            }
        });
        Bundle bundle = getIntent().getExtras();
        String comprueba=bundle.getString("Usuarios");
        if(comprueba.equals("Anonimo")==false)
        {
            error2.setText(error2.getText().toString()+ " como " +comprueba);
            botonAcceder.setVisibility(View.INVISIBLE);
            error2.setVisibility(View.VISIBLE);
        }
    }
}
