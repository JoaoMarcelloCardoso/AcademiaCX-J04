package com.demo.academiacx.model.dto;

import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.model.EnderecoModel;

public class EnderecoDto {
    private String cep;

    private String logradouro;

    private String bairro;

    private String cidade;

    private String numeroEndereco;

    private String UF;

    private ClienteModel cliente_id;

    public EnderecoDto() {
    }

    public EnderecoDto(EnderecoModel enderecoModel) {
        this.cep = enderecoModel.getCep();
        this.logradouro = enderecoModel.getLogradouro();
        this.bairro = enderecoModel.getBairro();
        this.cidade = enderecoModel.getCidade();
        this.numeroEndereco = enderecoModel.getNumeroEndereco();
        this.UF = enderecoModel.getUF();
        this.cliente_id = enderecoModel.getClienteModel();
    }

    public ClienteModel getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(ClienteModel cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
}
