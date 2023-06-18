package org.example.desafio;

import java.time.LocalDate;

public class Vendas {
   private Vendedor vendedor;
    private Cliente cliente;
    private int codigo;
    private String nomeProduto;
    private double preco;
    private int quantidade;
    private double valorTotal;
    private LocalDate data;

    public Vendas(Vendedor vendedor,Cliente cliente,int codigo, String nomeProduto, double preco, int quantidade,LocalDate data) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.valorTotal = preco * quantidade;
        this.data=data;
    }
    public Vendedor getVendedor() {
        return vendedor;
    }
    public Cliente getCliente() {
        return cliente;
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

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public LocalDate getData() {
        return data;
    }
}
