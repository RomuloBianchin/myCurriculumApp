package com.example.mycurriculumapp;

// Classe que contém os objetos que precisamos exibir na lista customizada.
public class ItensLista {

    // Criando as variáveis correspondente a cada tipo de objeto.
    public String assunto;
    public String descricao;
    public int imagens;


    // Criando o método construtor de cada objeto.
    public ItensLista(String assunto, String descricao, int imagens) {
        this.assunto = assunto;
        this.descricao = descricao;
        this.imagens = imagens;
    }

    // Criando os getters and setters.
    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImagens() {
        return imagens;
    }

    public void setImagens(int imagens) {
        this.imagens = imagens;
    }
}
