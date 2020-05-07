package com.example.mycurriculumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Alterando os atríbutos, caracteristicas da actionBar que será exibida na MainActivity.
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#880352C5")));


        ListView lista = (ListView) findViewById(R.id.listViewItens); // Passando o Id do XML da lista sem customização.
        ArrayList<ItensLista> itensLista = adicionarItens(); // Adicionado os itens dentro da variável itensLista, para que seja possível manipular no método onClick.
        ArrayAdapter adapter = (ArrayAdapter) new ItensListaAdapter(this, itensLista); // Adicionando cada item da lista no layout.
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(view.getContext(),DadosPessoais.class);
                    startActivityForResult(intent,0);
                }
                if (position == 1){
                    Intent intent = new Intent(view.getContext(),Experiencia.class);
                    startActivityForResult(intent,1);
                }
                if (position == 2){
                    Intent intent = new Intent(view.getContext(),Escolas.class);
                    startActivityForResult(intent,2);
                }
                if (position == 3){
                    Intent intent = new Intent(view.getContext(),Habilidades.class);
                    startActivityForResult(intent,3);
                }
                if (position == 4){
                    Intent intent = new Intent(view.getContext(),FraseFavoritas.class);
                    startActivityForResult(intent,4);
                }
                if (position == 5){
                    Intent intent = new Intent(view.getContext(), GerarFrasesMotivadoras.class);
                    startActivityForResult(intent,5);
                }
                if (position == 6){
                    Intent intent = new Intent(view.getContext(), GameRockPaperScisors.class);
                    startActivityForResult(intent,6);
                }

            }
        });


    }

    // Método que receberá as informações de cada objeto da linha, como textos, imagens, etc..
    private ArrayList<ItensLista> adicionarItens() {
        ArrayList<ItensLista> itens = new ArrayList<ItensLista>();

        // Inserindo o primeiro item
        ItensLista i = new ItensLista("Personal Informations: ","Here I´ll be showing some details as: wehre I lieve, my contact and e-mail.",R.drawable.perfil_azul);
        itens.add(i);

        // Inserindo o segundo item
        i = new ItensLista("Experience","Here I´ll show my entire professional experience.",R.drawable.movie_azul);
        itens.add(i);

        // Inserindo o terceiro item
        i = new ItensLista("Education","Here I´ll apresent the most important courses I´ve done",R.drawable.escolas);
        itens.add(i);

        // Inserindo o quarto item
        i = new ItensLista("Skills and Objectives","Here I´ll discribe some of my skills. ",R.drawable.skills);
        itens.add(i);

        // Inserindo o quinto item
        i = new ItensLista("Favourite phrase","This is my favourite phrase, of my favourite movie, I always try to use it to become stronger in any situation",R.drawable.frase_favorita);
        itens.add(i);

        // Inserindo o sexto item
        i = new ItensLista("Motivated Phrases to keep going!","Randomly 7 possible positive phrases",R.drawable.book);
        itens.add(i);

        // Inserindo o sétimo item
        i = new ItensLista("(Game) Rock, Paper and Scisors","As no one is made of Iron, Let´s play a game",R.drawable.joystick);
        itens.add(i);

        return itens;

        }

}