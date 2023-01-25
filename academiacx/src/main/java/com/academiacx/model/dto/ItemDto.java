package com.academiacx.model.dto;

import com.academiacx.model.CarrinhoModel;
import com.academiacx.model.ItemModel;
import com.academiacx.model.PrecoModel;
import com.academiacx.model.ProdutoModel;

import java.math.BigDecimal;


public class ItemDto {

    private Long id;
    private int quantidade;
    private BigDecimal total;
    private ProdutoModel produtoModel;
    private PrecoModel precoModel;
    private CarrinhoModel carrinhoModel;


    public ItemDto() {

    }

    public ItemDto(ItemModel itemModel) {
        this.id = itemModel.getId();
        this.quantidade = itemModel.getQuantidade();
        this.total = itemModel.getTotal();
        this.produtoModel = itemModel.getProdutoModel();
        this.precoModel = itemModel.getPrecoModel();
        this.carrinhoModel = itemModel.getCarrinhoModel();
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public ProdutoModel getProdutoModel() {
        return produtoModel;
    }

    public void setProdutoModel(ProdutoModel produtoModel) {
        this.produtoModel = produtoModel;
    }

    public PrecoModel getPrecoModel() {
        return precoModel;
    }

    public void setPrecoModel(PrecoModel precoModel) {
        this.precoModel = precoModel;
    }

    public CarrinhoModel getCarrinhoModel() {
        return carrinhoModel;
    }

    public void setCarrinhoModel(CarrinhoModel carrinhoModel) {
        this.carrinhoModel = carrinhoModel;
    }
}
