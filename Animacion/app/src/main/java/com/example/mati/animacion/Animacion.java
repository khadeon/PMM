package com.example.mati.animacion;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class Animacion extends AppCompatActivity {
    AnimationDrawable animacion;
    TransitionDrawable mi_transi = (TransitionDrawable)
            getResources().getDrawable(R.anim.animacion2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animacion=(AnimationDrawable) getResources().getDrawable(R.anim.animacion);
        ImageView imagen=new ImageView(this);
        imagen.setBackgroundColor(Color.WHITE);
        imagen.setImageDrawable(animacion);
        setContentView(imagen);

        imagen.setImageDrawable(mi_transi);
    }

    public boolean onTouchEvent(MotionEvent evento)
    {
        if(evento.getAction() == MotionEvent.ACTION_DOWN)
        {
            animacion.start();
            mi_transi.startTransition(2000);
            return true;
        }
        return super.onTouchEvent(evento);
    }

}