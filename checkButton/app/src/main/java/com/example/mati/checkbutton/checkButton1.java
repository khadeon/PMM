package com.example.mati.checkbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class checkButton1 extends AppCompatActivity {



        CheckBox chkBoxCycling;
        CheckBox chkBoxTeaching;
        CheckBox chkBoxBlogging;
        Button btnHobby;
        TextView txtHobby;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            //TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_check_button1);

            initialUISetup();
        }

        public void initialUISetup() {
            chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
            chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
            chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
            //btnHobby = (Button) findViewById(R.id.btnHobby);
            txtHobby = (TextView) findViewById(R.id.txtHobby);

            chkBoxBlogging.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getHobbyClick(buttonView);
                }
            });


            chkBoxCycling.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getHobbyClick(buttonView);
                }
            });

            chkBoxTeaching.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getHobbyClick(buttonView);
                }
            });

        }

        public void getHobbyClick(View v) {
            String strMessage = "";

            if (chkBoxCycling.isChecked()) {
                strMessage += "Ciclismo ";
            }
            if (chkBoxTeaching.isChecked()) {
                strMessage += "Enseñar ";
            }
            if (chkBoxBlogging.isChecked()) {
                strMessage += "Chatear ";
            }
            showTextNotification(strMessage);
        }

        public void showTextNotification(String msgToDisplay) {
            txtHobby.setText("Te gusta: "+msgToDisplay);
            //Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();

        }

}
