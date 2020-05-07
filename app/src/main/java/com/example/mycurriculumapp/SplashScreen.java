package com.example.mycurriculumapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // Ocultando a Actionbar da tela do splashScreen.
        Objects.requireNonNull(getSupportActionBar()).hide();


        // Criando um objeto Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),SensorAcelerometer.class));
                finish(); // Método finish para caso o usuário aperte o botão voltar, o splashScreen esteja destruído e não seja reexibido.
            }
        },4500); // Tempo em que o SplashScreen ficará em exibição em milissegundos.

    }

}
