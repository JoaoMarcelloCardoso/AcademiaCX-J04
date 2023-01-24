package com.spring.academiacx.model.dto;

import com.spring.academiacx.model.UserModel;
import com.spring.academiacx.model.ProdutoModel;

public class PrecoDto {

    private Long id;
    private float valor;

    private ProdutoModel produtoDto;

    private UserModel userModel;

    public PrecoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public ProdutoModel getProdutoModel() {
        return produtoDto;
    }

    public void setProdutoModel(ProdutoModel produtoDto) {
        this.produtoDto = produtoDto;
    }

    public UserModel getClienteModel() {
        return userModel;
    }

    public void setClienteModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
