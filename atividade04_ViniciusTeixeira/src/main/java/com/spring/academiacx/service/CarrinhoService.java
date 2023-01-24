package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.CarrinhoModel;
import com.spring.academiacx.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<CarrinhoModel> findAll() {
        List<CarrinhoModel> carrinhoDtos = carrinhoRepository.findAll();

        return carrinhoDtos;
    }

    public CarrinhoModel findById(CarrinhoModel carrinhoDto) {

        if (carrinhoDto == null) {
            throw new ParametroInvalidoException("O Model Carrinho deve informado");

        }

        if (carrinhoDto.getId() == null) {
            throw new ParametroInvalidoException("O Model Carrinho deve conter um id");

        }

        try {
            carrinhoDto = carrinhoRepository.findById(carrinhoDto.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return carrinhoDto;
    }

    public CarrinhoModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        CarrinhoModel carrinhoDto = new CarrinhoModel();
        try {
            carrinhoDto = carrinhoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return carrinhoDto;
    }

    public CarrinhoModel insert(CarrinhoModel carrinhoDto) {
        carrinhoDto.setId(null);

        CarrinhoModel result = carrinhoRepository.save(carrinhoDto);

        return result;
    }

    public CarrinhoModel update(CarrinhoModel carrinhoDto) {

        findById(carrinhoDto);


        return carrinhoRepository.save(carrinhoDto);
    }

    public boolean delete(Long id) {

        findById(id);

        carrinhoRepository.deleteById(id);

        return true;
    }
}