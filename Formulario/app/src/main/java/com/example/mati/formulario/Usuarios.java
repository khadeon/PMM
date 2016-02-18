package com.example.mati.formulario;

/**
 * Created by mati on 15/02/16.
 */
public class Usuarios {
    String usuario, contraseña;

    public Usuarios(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña=contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
