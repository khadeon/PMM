package com.example.mati.ibenavente;

/**
 * Created by mati on 9/11/15.
 */
public class Pizza {
    private String nombre;
    private String ingrediente;
    private double precio;
    private int imagen;

    public Pizza(String nombre, String ingrediente, double precio, int imagen)
    {
        this.nombre=nombre;
        this.ingrediente=ingrediente;
        this.precio=precio;
        this.imagen=imagen;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getIngrediente()
    {
        return ingrediente;
    }

    public double getPrecio()
    {
        return precio;
    }

    public int getImagen()
    {
        return imagen;
    }

    public void setNombre(String nuevoN)
    {
        nombre=nuevoN;
    }

    public void setIngrediente(String nuevoI)
    {
        ingrediente=nuevoI;
    }

    public void setPrecio(Double nuevoP)
    {
        precio=nuevoP;
    }

    public void setImagen(int nuevaI)
    {
        imagen=nuevaI;
    }

}
