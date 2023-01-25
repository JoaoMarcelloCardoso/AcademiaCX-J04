package com.academiacx.models.dto;

import com.academiacx.models.ClienteModel;

public class ClienteDto {
    private String cpf;
    private String nome;


    public ClienteDto(String cpf, String nome, String username) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public ClienteDto() {
    }

    public ClienteDto(ClienteModel clienteModel) {
        this.cpf = clienteModel.getCpf();
        this.nome = clienteModel.getNome();
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

}
