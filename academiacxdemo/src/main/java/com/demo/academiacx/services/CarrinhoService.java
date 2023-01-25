package com.demo.academiacx.services;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.*;
import com.demo.academiacx.model.dto.CarrinhoDto;
import com.demo.academiacx.repository.CarrinhoRepository;
import org.modelmapper.ModelMapper;
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
        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        CarrinhoModel carrinhoModel = new CarrinhoModel();
        try {
            carrinhoModel = carrinhoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return carrinhoModel;  }


    public CarrinhoModel update(CarrinhoModel carrinhoModel) {

        findById(carrinhoModel);


        return carrinhoRepository.save(carrinhoModel);
    }

    public boolean delete(Long id) {
        findById(id);
        carrinhoRepository.deleteById(id);
        return true;
    }


    public CarrinhoDto insert(CarrinhoDto carrinhoDto) {
    }
}
