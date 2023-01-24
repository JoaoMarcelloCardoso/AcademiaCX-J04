package com.example.ecommerce.service;

import com.example.ecommerce.handler.exceptions.RecursoNaoEncontradoException;
import com.example.ecommerce.model.EnderecoModel;
import com.example.ecommerce.model.dto.EnderecoDto;
import com.example.ecommerce.repository.EnderecoRepository;
import org.springframework.stereotype.Service;


@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    private final ModelMapper modelMapper;

    public EnderecoService(EnderecoRepository enderecoRepository, ModelMapper modelMapper) {
        this.enderecoRepository = enderecoRepository;
        this.modelMapper = modelMapper;
    }

    public EnderecoDto findById(Long id) {
        EnderecoModel enderecoModel = enderecoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Endereco não encontrado com id: " + id));
        return new EnderecoDto(enderecoModel);
    }

    public EnderecoDto insert(EnderecoDto enderecoDto) {
        enderecoDto.setId(null);
        EnderecoModel enderecoModel = new EnderecoModel(enderecoDto);
        enderecoModel = enderecoRepository.save(enderecoModel);
        return new EnderecoDto(enderecoModel);
    }

    public EnderecoDto update(EnderecoDto enderecoDto) {
        EnderecoModel enderecoModel = enderecoRepository.findById(enderecoDto.getId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Endereco não encontrado com id: " + enderecoDto.getId()));
        enderecoModel.setLogradouro(enderecoDto.getRua());
        enderecoModel.setCidade(enderecoDto.getCidade());
        enderecoModel = enderecoRepository.save(enderecoModel);
        return new EnderecoDto(enderecoModel);
    }

    public boolean delete(Long id) {
        findById(id);
        enderecoRepository.deleteById(id);
        return true;
    }
}