package com.spring.academiacx.model;


import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "tb_carrinho")
public class CarrinhoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    private float total;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private UserModel userModel;

    public CarrinhoModel() {
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
