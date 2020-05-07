package com.example.mycurriculumapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;

public class GameRockPaperScisors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rock_paper_scisors);

        // Alterando os atríbutos, caracteristicas da actionBar que será exibida na MainActivity.
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#880352C5")));


    }

    public void chooseRock(View view) {
        this.playerChoices("pedra");
    }

    public void choosePaper(View view) {
        this.playerChoices("papel");
    }

    public void chooseScisors(View view) {
        this.playerChoices("tesoura");
    }

    // Método que irá receber como parâmetro um objeto do Tipo String, esse parametro irá capturar a jogada do usuário, para usarmos em comparações futuras.
    public void playerChoices(String escolhaJogador) {

        // Criando um objeto do tipo ImageView
        ImageView trocaImagem = findViewById(R.id.troca_imagem);
        TextView txtResultado = findViewById(R.id.txt_result);

        // Criando um objeto do tipo inteiro que irá acessar os atributos do método Random, para que seja possível criar 3 indices aleatórios.
        int numeroRandomico = new Random().nextInt(3);

        // Criando um objeto do tipo Array de string, para que possamos depois conseguir utilizar no switch
        String[] opcoes = {"pedra", "papel", "tesoura"}; // Pedra indice 0, papel indice 1, tesoura indice 2.

        // Criando um novo objeto do tipo String e passando as propriedades do objeto criado anteriormente opcoes.
        String opcoesApp = opcoes[numeroRandomico];

        // Switch para associar a imagem a string que foi gerada aleatóriamente.
        switch (opcoesApp) {
            case "pedra":
                trocaImagem.setImageResource(R.drawable.rock);
                break;

            case "papel":
                trocaImagem.setImageResource(R.drawable.paper);
                break;

            case "tesoura":
                trocaImagem.setImageResource(R.drawable.scisors);
        }

        // Essa condição irá conter todas as possibilidades da aplicação vencer.
        if ((opcoesApp == "pedra" & escolhaJogador == "tesoura") ||
                (opcoesApp == "papel" & escolhaJogador == "pedra") ||
                (opcoesApp == "tesoura" & escolhaJogador == "papel")) {
            txtResultado.setText("Você perdeu");


            // Essa condição irá conter todas as possibilidades do usuário vencer o jogo.
        } else if ((opcoesApp == "pedra" & escolhaJogador == "papel") ||
                (opcoesApp == "papel" & escolhaJogador == "tesoura") ||
                (opcoesApp == "tesoura" & escolhaJogador == "pedra")) {
            txtResultado.setText("Você ganhou");


        } else {
            txtResultado.setText("Empate");
        }

    }

}
