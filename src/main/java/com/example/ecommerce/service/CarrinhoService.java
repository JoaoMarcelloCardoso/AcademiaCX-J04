package com.example.ecommerce.service;

import com.example.ecommerce.handler.exceptions.RecursoNaoEncontradoException;
import com.example.ecommerce.model.CarrinhoModel;
import com.example.ecommerce.model.dto.CarrinhoDto;
import com.example.ecommerce.repository.CarrinhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

    private final ModelMapper modelMapper;

    public CarrinhoService(CarrinhoRepository carrinhoRepository, ModelMapper modelMapper) {
        this.carrinhoRepository = carrinhoRepository;
        this.modelMapper = modelMapper;
    }

    public List<CarrinhoDto> findAll() {
        List<CarrinhoModel> carrinhoModels = carrinhoRepository.findAll();
        return CarrinhoDto.parseList(carrinhoModels);
    }

    public CarrinhoDto findById(Long id) {
        CarrinhoModel carrinhoModel = carrinhoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Carrinho não encontrado com id: " + id));
        return new CarrinhoDto(carrinhoModel);  }


    public CarrinhoDto update(CarrinhoDto carrinhoDto) {
        CarrinhoModel carrinhoModel = carrinhoRepository.findById(carrinhoDto.getId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Carrinho não encontrado com id: " + carrinhoDto.getId()));
        carrinhoModel.setDataHora(carrinhoDto.getDataHora());
        carrinhoModel.setTotal(carrinhoDto.getTotal());
        carrinhoModel = carrinhoRepository.save(carrinhoModel);
        return new CarrinhoDto(carrinhoModel);
    }

    public boolean delete(Long id) {
        findById(id);
        carrinhoRepository.deleteById(id);
        return true;
    }
}