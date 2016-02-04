package com.example.mati.bicijuego;

/**
 * Created by mati on 21/12/15.
 */
import android.os.Bundle;
import android.preference.PreferenceActivity;
public class PantallaOpciones extends PreferenceActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones);
    }
}
