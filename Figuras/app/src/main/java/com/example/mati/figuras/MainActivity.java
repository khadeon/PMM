package com.example.mati.figuras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchDrawShapes1(View clickedButton) {
        Intent activityIntent =
                new Intent(this, Figura1.class);
        startActivity(activityIntent);
    }
    public void launchDrawShapes2(View clickedButton) {
        Intent activityIntent =
                new Intent(this, Figura2.class);
        startActivity(activityIntent);
    }
    public void launchDrawShapes3(View clickedButton) {
        Intent activityIntent =
                new Intent(this, Figura3.class);
        startActivity(activityIntent);
    }
}
