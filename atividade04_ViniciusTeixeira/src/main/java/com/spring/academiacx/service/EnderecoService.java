package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.EnderecoModel;
import com.spring.academiacx.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoModel> findAll() {
        List<EnderecoModel> enderecoDtos = enderecoRepository.findAll();

        return enderecoDtos;
    }

    public EnderecoModel findById(EnderecoModel enderecoDto) {

        if (enderecoDto == null) {
            throw new ParametroInvalidoException("O Model Endereco deve informado");

        }

        if (enderecoDto.getId() == null) {
            throw new ParametroInvalidoException("O Model Endereco deve conter um id");

        }

        try {
            enderecoDto = enderecoRepository.findById(enderecoDto.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return enderecoDto;
    }

    public EnderecoModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        EnderecoModel enderecoDto = new EnderecoModel();
        try {
            enderecoDto = enderecoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return enderecoDto;
    }

    public EnderecoModel insert(EnderecoModel enderecoDto) {
        enderecoDto.setId(null);

        EnderecoModel result = enderecoRepository.save(enderecoDto);

        return result;
    }

    public EnderecoModel update(EnderecoModel enderecoDto) {

        findById(enderecoDto);


        return enderecoRepository.save(enderecoDto);
    }

    public boolean delete(Long id) {

        findById(id);

        enderecoRepository.deleteById(id);

        return true;
    }
}

