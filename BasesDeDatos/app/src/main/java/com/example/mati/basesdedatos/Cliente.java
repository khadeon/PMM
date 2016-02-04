package com.example.mati.basesdedatos;

/**
 * Created by mati on 18/01/16.
 */
public class Cliente {
    private String nombreCli;
    private String telefonoCli;
    public Cliente(String nombreCli, String telefonoCli) {
        this.nombreCli=nombreCli;
        this.telefonoCli=telefonoCli;
    }

    public String getNombre() {
        return nombreCli;
    }

    public String getTlf() {
        return telefonoCli;
    }
}
