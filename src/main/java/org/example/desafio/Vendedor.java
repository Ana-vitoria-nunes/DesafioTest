package org.example.desafio;

public class Vendedor {
    private String email;
    private String nome;
    private int cpf;

    public Vendedor(String email,String nome,int cpf){
        this.email=email;
        this.nome =nome;
        this.cpf=cpf;
    }
    public String getEmail() {
        return email;
    }
    public String getNome() {
        return nome;
    }
    public int getCpf() {
        return cpf;
    }
}
