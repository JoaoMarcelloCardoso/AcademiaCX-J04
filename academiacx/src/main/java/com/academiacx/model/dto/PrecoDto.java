package com.academiacx.model.dto;

import com.academiacx.model.ClienteModel;
import com.academiacx.model.PrecoModel;
import com.academiacx.model.ProdutoModel;

import java.math.BigDecimal;


public class PrecoDto {

    private Long id;
    private BigDecimal valor;

    private ProdutoModel produtoModel;

    private ClienteModel clienteModel;


    public PrecoDto() {

    }

    public PrecoDto(PrecoModel precoModel) {
        this.id = precoModel.getId();
        this.valor = precoModel.getValor();
        this.produtoModel = precoModel.getProdutoModel();
        this.clienteModel = precoModel.getClienteModel();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public ProdutoModel getProdutoModel() {
        return produtoModel;
    }

    public void setProdutoModel(ProdutoModel produtoModel) {
        this.produtoModel = produtoModel;
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }
}
