package com.demo.academiacx.model.dto;

public class ItemDto {

    private Long id;
    private Integer quantidade;
    private Double total;

    public ItemDto(Long id, Integer quantidade, Double total) {
        this.id = id;
        this.quantidade = quantidade;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


}
