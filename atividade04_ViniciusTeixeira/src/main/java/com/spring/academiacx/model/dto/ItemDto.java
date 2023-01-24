package com.spring.academiacx.model.dto;

import com.spring.academiacx.model.CarrinhoModel;
import com.spring.academiacx.model.PrecoModel;
import com.spring.academiacx.model.ProdutoModel;

public class ItemDto {

    private Long id;
    private int quantidade;
    private float total;

    private ProdutoModel produtoDto;

    private PrecoModel precoDto;

    private CarrinhoModel carrinhoDto;

    public ItemDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ProdutoModel getProdutoModel() {
        return produtoDto;
    }

    public void setProdutoModel(ProdutoModel produtoDto) {
        this.produtoDto = produtoDto;
    }

    public PrecoModel getPrecoModel() {
        return precoDto;
    }

    public void setPrecoModel(PrecoModel precoDto) {
        this.precoDto = precoDto;
    }

    public CarrinhoModel getCarrinhoDto() {
        return carrinhoDto;
    }

    public void setCarrinhoDto(CarrinhoModel carrinhoDto) {
        this.carrinhoDto = carrinhoDto;
    }
}
