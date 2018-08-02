package com.example.italo.mediaescolarmvc.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.italo.mediaescolarmvc.R;
import com.example.italo.mediaescolarmvc.controller.MediaEscolarController;
import com.example.italo.mediaescolarmvc.model.MediaEscolar;

import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        apresentarTelaSplash();


    }


    private void apresentarTelaSplash(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {



                MediaEscolarController mediaEscolarController = new MediaEscolarController(getBaseContext());




                List<MediaEscolar> objetos = mediaEscolarController.listar();

                for (MediaEscolar obj  : objetos ){
                    Log.i("CRUD LISTAR", "ID: " + obj.getId() + " - Matéria: " + obj.getMateria() + " - Situação: " + obj.getSituacao());
                }


                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);

                startActivity(telaPrincipal);
                finish();


            }
        }, SPLASH_TIME_OUT);

    }

}
