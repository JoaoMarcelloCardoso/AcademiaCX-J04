package com.demo.academiacx.model.dto;

import com.demo.academiacx.model.CarrinhoModel;
import com.demo.academiacx.model.ClienteModel;

import java.time.LocalDateTime;
import java.util.Date;

public class CarrinhoDto {

    private Long id;
    private Date data;
    private double total;

    private ClienteModel clienteModel;


    public CarrinhoDto() {

    }

    public CarrinhoDto(Long id, Date data, double total, ClienteModel clienteModel) {
        this.id = id;
        this.data = data;
        this.total = total;
        this.clienteModel = clienteModel;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }
}