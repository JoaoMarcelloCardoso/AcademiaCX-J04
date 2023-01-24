package com.example.ecommerce.service;


import com.example.ecommerce.handler.exceptions.RecursoNaoEncontradoException;
import com.example.ecommerce.model.ClienteModel;
import com.example.ecommerce.model.dto.ClienteDto;
import com.example.ecommerce.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final ModelMapper modelMapper;

    public ClienteService(ClienteRepository clienteRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }

    public ClienteDto findById(Long id) {
        ClienteModel clienteModel = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado com id: " + id));
        return new ClienteDto(clienteModel);
    }

    public ClienteDto insert(ClienteDto clienteDto) {
        clienteDto.setId(null);
        ClienteModel clienteModel = new ClienteModel(clienteDto);
        clienteModel = clienteRepository.save(clienteModel);
        return new ClienteDto(clienteModel);
    }

    public ClienteDto update(ClienteDto clienteDto) {
        ClienteModel clienteModel = clienteRepository.findById(clienteDto.getId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado com id: " + clienteDto.getId()));
        clienteModel.setCpf(clienteDto.getCpf());
        clienteModel.setNome(clienteDto.getNome());
        clienteModel = clienteRepository.save(clienteModel);
        return new ClienteDto(clienteModel);
    }

    public boolean delete(Long id) {
        findById(id);
        clienteRepository.deleteById(id);
        return true;
    }
}