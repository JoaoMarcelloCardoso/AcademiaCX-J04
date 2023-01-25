package com.demo.academiacx.model;

import com.demo.academiacx.model.dto.EnderecoDto;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_endereco")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String cep;

    private String logradouro;

    private String bairro;

    private String cidade;

    private String numeroEndereco;

    //Utilizei como base o código de UF que está na nota fiscal
    private String UF;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente_id;


    public EnderecoModel(EnderecoDto enderecoDto) {
        this.cep = enderecoDto.getCep();
        this.logradouro = enderecoDto.getLogradouro();
        this.bairro = enderecoDto.getBairro();
        this.cidade = enderecoDto.getCidade();
        this.numeroEndereco = enderecoDto.getNumeroEndereco();
        this.UF = enderecoDto.getUF();
        this.cliente_id = enderecoDto.getCliente_id();
    }

    public EnderecoModel() {

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

    public ClienteModel getClienteModel() {
        return cliente_id;
    }

    public void setClienteModel(ClienteModel cliente) {
        this.cliente_id = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
