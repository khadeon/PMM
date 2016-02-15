package com.example.mati.formulario;

import android.app.AlertDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registro extends AppCompatActivity
{
    SQLiteDatabase db;
    Button botonAcceder, botonRegistrando;
    String usuario, contraseña;
    EditText usuarioEdit=(EditText)findViewById(R.id.textoUsuario);
    EditText contraseñaEdit=(EditText)findViewById(R.id.textoContraeña);
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_usuario);


        db.execSQL(codSQL);

        botonRegistrando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = usuarioEdit.getText().toString();
                contraseña = contraseñaEdit.getText().toString();
                String codREgistro = "INSERT INTO Usuarios (usuario, contraseña)" +
                        "VALUES(" + usuario + ", '" + contraseña + "')";
                db.execSQL(codREgistro);
            }
        });

        botonAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = usuarioEdit.getText().toString();
                contraseña = contraseñaEdit.getText().toString();

            }
        });
    }
}
