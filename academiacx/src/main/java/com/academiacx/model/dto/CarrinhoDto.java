package com.academiacx.model.dto;

import com.academiacx.model.CarrinhoModel;
import com.academiacx.model.ClienteModel;

import java.math.BigDecimal;
import java.util.Date;


public class CarrinhoDto {

    private Long id;
    private Date data;
    private BigDecimal total;

    private ClienteModel clienteModel;


    public CarrinhoDto() {

    }

    public CarrinhoDto(CarrinhoModel carrinhoModel) {
        this.id = carrinhoModel.getId();
        this.total = carrinhoModel.getTotal();
        this.data = carrinhoModel.getData();
        this.clienteModel = carrinhoModel.getClienteModel();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }
}
