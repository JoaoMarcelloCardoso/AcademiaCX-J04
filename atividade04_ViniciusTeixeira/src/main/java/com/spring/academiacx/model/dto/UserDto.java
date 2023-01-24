package com.spring.academiacx.model.dto;


import com.spring.academiacx.model.UserModel;

public class UserDto {

    private Long id;
    private String nome;


    public UserDto(UserModel userModel) {
        this.id= userModel.getId();
        this.nome= userModel.getNome();

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

}
