package com.example.mati.formulario;

public class Destino {
    private String zona;
    private String continente;
    private String precio;
    private int imagen;

    public Destino(String zona, String continente, String precio,int imagen)
    {
        this.zona=zona;
        this.continente=continente;
        this.precio=precio;
        this.imagen=imagen;
    }

    public String getZona()
    {
        return this.zona;
    }
    public String getContinente()
    {
        return this.continente;
    }
    public String getPrecio()
    {
        return this.precio;
    }
    public int getImagen()
    {
        return this.imagen;
    }

    public void setZona(String zona)
    {
        this.zona=zona;
    }
    public void setContinente(String continente)
    {
        this.continente=continente;
    }
    public void setPrecio(String precio)
    {
        this.precio=precio;
    }
    public void setImagen(int imagen)
    {
        this.imagen=imagen;
    }


}
