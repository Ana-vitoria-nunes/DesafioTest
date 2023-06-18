package org.example.desafio;

public class Produto {
    private int codigo;
    private String nomeProduto;
    private double preco;
    public Produto(int codigo, String nomeProduto, double preco) {
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.preco = preco;

    }
    public int getCodigo() {
        return codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

}
