package com.example.ecommerce.config.security;

import com.example.ecommerce.model.CarrinhoModel;
import com.example.ecommerce.repository.CarrinhoRepository;
import com.example.ecommerce.service.CarrinhoService;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    final CarrinhoRepository carrinhoRepository;

    public CarrinhoServiceImpl(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    @Override
    public CarrinhoModel loadCarrinhoByID(Long id) throws CarrinhoNotFoundException {
        CarrinhoModel carrinhoModel = carrinhoRepository.findById(id)
                .orElseThrow(() -> new CarrinhoNotFoundException("Carrinho não encontrado com ID: " + id));

        return carrinhoModel;
    }
}