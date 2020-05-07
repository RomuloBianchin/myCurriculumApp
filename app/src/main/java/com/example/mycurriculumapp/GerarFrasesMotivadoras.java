package com.example.mycurriculumapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;

public class GerarFrasesMotivadoras extends AppCompatActivity {

    public String[] frases ={"Push yourself, because no one else is going to do it for you. ( 1/7 )", // Incice 0
            "Great things never come from comfort zones. ( 2/7 )",// Incice 1
            "Success doesn’t just find you. You have to go out and get it. ( 3/7 )",// Incice 2
            "The harder you work for something, the greater you’ll feel when you achieve it. ( 4/7 )",// Incice 3
            "Dream bigger. Do bigger. ( 5/7 )",// Incice 4
            "Don’t stop when you’re tired. Stop when you’re done. ( 6/7 )",// Incice 5
            "Wake up with determination. Go to bed with satisfaction. ( 7/7 )"};// Incice 6

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frases_motivar);

        // Alterando os atríbutos, caracteristicas da actionBar que será exibida na MainActivity.
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#880352C5")));


        //Calling for the method.
        gerarFrasesAleatorias();

    }

    public void gerarFrasesAleatorias(){
        // Signing the Button object with the id
        Button btnGerarFrases = findViewById(R.id.btn_gerar_frases);

        // Signing the TextView object with the id
        final TextView resultadoFrase = findViewById(R.id.resultadoFrase);

        // Creating the method onCLick instead of just passing it directly with the View view.
        btnGerarFrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generating a randomic number.
                final int numRandomico = new Random().nextInt(6);
                // Using the method setText to pass the phrases with the indices for the object TextView.
                resultadoFrase.setText(frases[numRandomico]);

            }
        });


    }
}
