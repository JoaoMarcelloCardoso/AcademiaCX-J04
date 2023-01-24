package com.example.ecommerce.service;

import com.example.ecommerce.handler.exceptions.RecursoNaoEncontradoException;
import com.example.ecommerce.model.ProdutoModel;
import com.example.ecommerce.model.dto.ProdutoDto;
import com.example.ecommerce.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import com.example.ecommerce.handler.exceptions.ParametroInvalidoException;


@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ModelMapper modelMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
        this.modelMapper = modelMapper;   }

    public ProdutoDto findById(ProdutoModel produtoModel) {
        if (produtoModel == null) {
            throw new ParametroInvalidoException("A Produto Model deve informada");
        }

        if (produtoModel.getId() == null) {
            throw new ParametroInvalidoException("A Produto Model deve conter um id");
        }

        try {
            produtoModel = produtoRepository.findById(produtoModel.getId()).get();
        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(produtoModel, ProdutoDto.class);
    }

    public ProdutoDto findById(Long id) {
        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        ProdutoModel produtoModel = new ProdutoModel();
        try {
            produtoModel = produtoRepository.findById(id).get();
        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(produtoModel, ProdutoDto.class);
    }

    public ProdutoDto insert(ProdutoDto produtoDto) {
        produtoDto.setId(null);

        ProdutoDto result = new ProdutoDto(produtoRepository.save(new ProdutoModel(produtoDto)));

        return result;
    }

    public ProdutoModel update(ProdutoModel produtoModel) {
        findById(produtoModel);

        return produtoRepository.save(produtoModel);
    }

    public boolean delete(Long id) {
        findById(id);

        produtoRepository.deleteById(id);

        return true;
    }

}