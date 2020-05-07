package com.example.mycurriculumapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


// Classe que iremos extender para a classe do tipo ArrayAdapter e passar como parâmetro a classe que possuí os nossos objetos
// que será utilizados, nesse caso, será os obejtos da classe ItensLista.
public class ItensListaAdapter extends ArrayAdapter<ItensLista> {

    // Setando os tipos de objetos que iremos utilizar para acessar os objetos.
    private final Context context;
    private final ArrayList<ItensLista> elementos;

    // Método contrutos dos elementos dessa classe.
    public ItensListaAdapter(Context context, ArrayList<ItensLista> elementos) {
        super(context,R.layout.linha,elementos); // Obtendo o recurso do layout customizado e os seus elementos.
        this.context = context;
        this.elementos = elementos;
    }

    // Método que irá construír linha a linha do nossa Lista, respeitando as caracteristicas previamente definidas no layout.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Criando um objeto do tipo LayoutInflater para que possamos instanciar o arquivo XML correspondente.
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Criando um objeto do tipo View, passando o objeto inflate passando como parâmetros o layout customizado.
        View rowView = (View) layoutInflater.inflate(R.layout.linha,parent,false);


        // Associando os Id´s do XML ao layout customizado a cada objeto que será utilizado para obter o indice da possição e definir os atríbutos.
        TextView descAssunto = rowView.findViewById(R.id.assuntoLista);
        TextView desDescricao = rowView.findViewById(R.id.descricaoLista);
        ImageView imagemLista = rowView.findViewById(R.id.imagemsListView);

        descAssunto.setText(elementos.get(position).getAssunto());
        desDescricao.setText(elementos.get(position).getDescricao());
        imagemLista.setImageResource(elementos.get(position).getImagens());

        return rowView;
    }
}
