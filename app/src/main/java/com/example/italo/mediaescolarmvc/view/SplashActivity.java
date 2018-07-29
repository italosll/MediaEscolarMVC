package com.example.italo.mediaescolarmvc.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.italo.mediaescolarmvc.R;
import com.example.italo.mediaescolarmvc.controller.MediaEscolarController;
import com.example.italo.mediaescolarmvc.model.MediaEscolar;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000;

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

                //DataSource ds = new DataSource(getBaseContext()) ;

                MediaEscolar obj = new MediaEscolar();

                obj.setMateria("Matemática");
                obj.setBimestre("2° Bimestre");
                obj.setNotaProva(7);
                obj.setNotaMateria(7);
                obj.setMediaFinal(7);
                obj.setSituacao("Reprovado");

                MediaEscolarController mediaEscolarController = new MediaEscolarController(getBaseContext());


//                mediaEscolarController.salvar(obj);
//                mediaEscolarController.salvar(obj);
//                mediaEscolarController.salvar(obj);
//                mediaEscolarController.salvar(obj);
//                mediaEscolarController.salvar(obj);


                obj.setId(3);
                mediaEscolarController.alterar(obj);


                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);

                startActivity(telaPrincipal);
                finish();


            }
        }, SPLASH_TIME_OUT);

    }

}
