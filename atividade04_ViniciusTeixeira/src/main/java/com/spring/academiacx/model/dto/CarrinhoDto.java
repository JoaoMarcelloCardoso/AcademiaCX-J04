package com.spring.academiacx.model.dto;

import com.spring.academiacx.model.UserModel;

import java.time.LocalDateTime;

public class CarrinhoDto {

    private Long id;
    private LocalDateTime dataHora;
    private float total;

    private UserModel userModel;

    public CarrinhoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public UserModel getClienteModel() {
        return userModel;
    }

    public void setClienteModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
