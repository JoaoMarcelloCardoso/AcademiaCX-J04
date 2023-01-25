package com.example.ecommerce.model.dto;

import com.example.ecommerce.model.ProdutoModel;

public class ProdutoDto {
    private Long id;

    private String nome;

    public ProdutoDto() {
    }

    public ProdutoDto(ProdutoModel produtoModel) {
        this.id = produtoModel.getId();
        this.nome = produtoModel.getNome();
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