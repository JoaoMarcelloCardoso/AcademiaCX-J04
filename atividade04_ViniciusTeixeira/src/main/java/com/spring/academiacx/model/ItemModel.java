package com.spring.academiacx.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_item")
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    private float total;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produtoDto;

    @ManyToOne
    @JoinColumn(name = "preco_id")
    private PrecoModel precoDto;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private CarrinhoModel carrinhoDto;

    public ItemModel() {
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

    public CarrinhoModel getCarrinhoModel() {
        return carrinhoDto;
    }

    public void setCarrinhoModel(CarrinhoModel carrinhoDto) {
        this.carrinhoDto = carrinhoDto;
    }
}
