package com.demo.academiacx.model.dto;

public class ProdutoDto {
    private Long id;
    private String sku;
    private String nome;

    public ProdutoDto(Long id, String sku, String nome) {
        this.id = id;
        this.sku = sku;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
