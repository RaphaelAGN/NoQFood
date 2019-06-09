package com.example.android.noqfoodprototype.constructors;

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String password;
    private String numCartao;
    public Usuario() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumCartao() { return numCartao; }

    public void setNumCartao(String numCartao){ this.numCartao = numCartao; }

}