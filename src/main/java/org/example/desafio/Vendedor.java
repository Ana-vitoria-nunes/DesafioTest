package org.example.desafio;

public class Vendedor {
    private String email;
    private String nome;
    private int cpf;
    private String senha;

    public Vendedor(String email,String nome,int cpf, String senha){
        this.email=email;
        this.nome =nome;
        this.cpf=cpf;
        this.senha=senha;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
