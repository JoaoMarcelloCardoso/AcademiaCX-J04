package com.spring.academiacx.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_preco")
public class PrecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float valor;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produtoDto;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private UserModel userModel;

    public PrecoModel() {
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
