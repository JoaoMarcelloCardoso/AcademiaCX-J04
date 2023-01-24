package com.cx.academy.exerciciontt.model.dto.request;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ClientDtoRequest {

    private String cpf;
    private String nome;
    private String username;
    private String password;

    public ClientDtoRequest(String cpf, String nome, String username, String password) {
        this.cpf = cpf;
        this.nome = nome;
        this.username = username;
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}