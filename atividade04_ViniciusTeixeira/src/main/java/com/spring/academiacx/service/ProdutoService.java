package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.ProdutoModel;
import com.spring.academiacx.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoModel> findAll() {
        List<ProdutoModel> produtoDtos = produtoRepository.findAll();

        return produtoDtos;
    }

    public ProdutoModel findById(ProdutoModel produtoDto) {

        if (produtoDto == null) {
            throw new ParametroInvalidoException("O Model Produto deve informado");

        }

        if (produtoDto.getId() == null) {
            throw new ParametroInvalidoException("O Model Produto deve conter um id");

        }

        try {
            produtoDto = produtoRepository.findById(produtoDto.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return produtoDto;
    }

    public ProdutoModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        ProdutoModel produtoDto = new ProdutoModel();
        try {
            produtoDto = produtoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return produtoDto;
    }

    public ProdutoModel insert(ProdutoModel produtoDto) {
        produtoDto.setId(null);

        ProdutoModel result = produtoRepository.save(produtoDto);

        return result;
    }

    public ProdutoModel update(ProdutoModel produtoDto) {

        findById(produtoDto);


        return produtoRepository.save(produtoDto);
    }

    public boolean delete(Long id) {

        findById(id);

        produtoRepository.deleteById(id);

        return true;
    }
}




