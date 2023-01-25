package com.demo.academiacx.model.dto;


import com.demo.academiacx.model.ClienteModel;

import java.util.Optional;

public class ClienteDto {

    private Long id;
    private String nome;
    private String cpf;

    public ClienteDto() {

    }

    public ClienteDto(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public ClienteDto(Optional<ClienteModel> clienteModel) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}