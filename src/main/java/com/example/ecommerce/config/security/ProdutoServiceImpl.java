package com.example.ecommerce.config.security;

import com.example.ecommerce.model.ProdutoModel;
import com.example.ecommerce.repository.ProdutoRepository;
import com.example.ecommerce.service.ProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoModel loadProdutoByID(Long id) throws ProdutoNotFoundException {
        ProdutoModel produtoModel = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado com ID: " + id));

        return produtoModel;
    }
}