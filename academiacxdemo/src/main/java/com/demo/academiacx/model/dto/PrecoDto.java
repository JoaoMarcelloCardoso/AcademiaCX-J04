package com.demo.academiacx.model.dto;

public class PrecoDto {

    private Long id;
    private double valor;

    public PrecoDto(Long id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
