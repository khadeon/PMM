package com.example.mati.ejemplocanvas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

/**
 * Created by mati on 30/11/15.
 */

public class EjemploView extends View {
    private BitmapDrawable miImagen;
    public EjemploView(Context contexto) {
        super(contexto);
        Resources res = contexto.getResources();
        miImagen = (BitmapDrawable) res.getDrawable(R.drawable.logo_cefire);


    }
    @Override
    protected void onDraw(Canvas canvas) {
        //Dentro de este método utilizamos los métodos para dibujar BitmapDrawable
        int ancho=canvas.getWidth()/2;
        int alto=canvas.getHeight()/2;
        miImagen.setBounds(new Rect(ancho-300, alto-300, ancho+300, alto+300));
        Paint lienzo=new Paint();
        lienzo.setColor(Color.GREEN);
        lienzo.setStyle(Paint.Style.STROKE);
        lienzo.setStrokeWidth(10);
        canvas.drawCircle(ancho, alto, 500, lienzo);
        miImagen.draw(canvas);


    }
}


