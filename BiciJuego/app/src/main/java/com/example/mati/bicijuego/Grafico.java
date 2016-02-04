package com.example.mati.bicijuego;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by mati on 14/12/15.
 */
public class Grafico {
    private Drawable drawable;  //Imagen
    private double posX, posY;  //Posicion
    private double incX, incY; //Velocidad mov
    private int angulo, rotacion; //angulo y vel. rotacion
    private int alto, ancho; //de la imagen
    private int radioColision;  //choques
    private View view;

    public static final int MAX_VEL=20;

    public Grafico(View view, Drawable drawable){
        this.view=view;
        this.drawable=drawable;
        ancho=drawable.getIntrinsicWidth();
        alto=drawable.getIntrinsicHeight();
        radioColision=(alto+ancho)/4;
    }

    public void setIncX(double x) {incX=x;}

    public void setIncY(double y) {incY=y;}

    public void setAngulo(int a) {angulo=a;}

    public void setRotacion(int r) {rotacion = r;}

    public int getAncho() {return ancho;}

    public int getAlto() {return alto;}

    public void setPosX(double posX) {this.posX = posX;}

    public void setPosY(double posY) {this.posY = posY;}

    public void dibujoGrafico(Canvas canvas){
        canvas.save();
        int x=(int) (posX+ancho/2);
        int y=(int)(posY+alto/2);
        canvas.rotate((float) angulo, (float) x, (float) y);
        drawable.setBounds((int) posX, (int) posY, (int) posX + ancho, (int) posY + alto);
        drawable.draw(canvas);
        canvas.restore();

        int choqueInval = (int)distanciaE(0,0,ancho,alto)/2+MAX_VEL;
        view.invalidate(x-choqueInval,y-choqueInval,x+choqueInval,y+choqueInval);
    }

    public void incrementaPos()
    {
        posX+=incX;
        if(posX< -ancho/2){
            posX=view.getWidth()-ancho/2;
        }
        if(posX> -ancho/2){
            posX = -ancho/2;
        }
    }

    public static double distanciaE(double x, double y, double x2, double y2) {
        return Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2));
    }

    public double distancia(Grafico g) {
        return distanciaE(posX, posY, g.posX, g.posY);
    }
}
