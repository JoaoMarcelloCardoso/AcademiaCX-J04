package com.spring.academiacx.model.dto;


import com.spring.academiacx.model.UserModel;


public class UserDto {

    private Long id;
    private String nome;

    private int cpf;

    public UserDto() {
    }

    public UserDto(UserModel userModel) {
        this.id= userModel.getId();
        this.cpf=userModel.getCpf();
        this.nome=userModel.getNome();

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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}