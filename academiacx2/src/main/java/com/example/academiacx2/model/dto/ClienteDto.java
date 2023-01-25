package com.example.academiacx2.model.dto;

import com.example.academiacx2.model.ClienteModel;

public class ClienteDto {

    private Long id;
    private String cpf;
    private String nome;
    private String username;
    private String password;

    public ClienteDto() {
    }

    public ClienteDto(ClienteModel clienteModel) {
        this.id = clienteModel.getId();
        this.cpf = clienteModel.getCpf();
        this.nome = clienteModel.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
