package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.PrecoModel;
import com.spring.academiacx.repository.PrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecoService {

    @Autowired
    private PrecoRepository precoRepository;

    public List<PrecoModel> findAll() {
        List<PrecoModel> precoDtos = precoRepository.findAll();

        return precoDtos;
    }

    public PrecoModel findById(PrecoModel precoDto) {

        if (precoDto == null) {
            throw new ParametroInvalidoException("O Model Preco deve ser informado");

        }

        if (precoDto.getId() == null) {
            throw new ParametroInvalidoException("O Model Preco deve conter um id");

        }

        try {
            precoDto = precoRepository.findById(precoDto.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return precoDto;
    }

    public PrecoModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        PrecoModel precoDto = new PrecoModel();
        try {
            precoDto = precoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return precoDto;
    }

    public PrecoModel insert(PrecoModel precoDto) {
        precoDto.setId(null);

        PrecoModel result = precoRepository.save(precoDto);

        return result;
    }

    public PrecoModel update(PrecoModel precoDto) {

        findById(precoDto);


        return precoRepository.save(precoDto);
    }

    public boolean delete(Long id) {

        findById(id);

        precoRepository.deleteById(id);

        return true;
    }
}



