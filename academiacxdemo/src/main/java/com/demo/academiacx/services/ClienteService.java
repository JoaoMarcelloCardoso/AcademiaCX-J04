package com.demo.academiacx.services;


import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.model.dto.ClienteDto;
import com.demo.academiacx.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    private final ModelMapper modelMapper;

    public ClienteService(ClienteRepository clienteRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }

    public List<ClienteModel> findAll() {
        List<ClienteModel> clienteModels = clienteRepository.findAll();

        return modelMapper.map(clienteModels, new TypeToken<List<ClienteDto>>() {
        }.getType());

    }

    public ClienteModel findById(ClienteModel clienteModel) {

        if(clienteModel == null){
            throw new ParametroInvalidoException("A Cliente Model deve ser informada");

        }

        if (clienteModel.getId() == null) {
            throw new ParametroInvalidoException("A Cliente Model deve conter um id");

        }

        try {
            clienteModel = clienteRepository.findById(clienteModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map((Object) clienteModel, ClienteDto.class);
    }

    public ClienteDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        ClienteModel clienteModel = new ClienteModel();
        try {
            clienteModel = clienteRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return clienteModel;
    }

    public ClienteDto insert(ClienteDto clienteDto) {
        clienteDto.setId(null);

        ClienteDto result = new ClienteDto(clienteRepository.save(new ClienteModel(clienteDto)));

        return result;
    }

    public ClienteModel update(ClienteModel clienteModel) {

        findById(clienteModel);


        return clienteRepository.save(clienteModel);
    }

    public boolean delete(Long id) {

        findById(id);

        clienteRepository.deleteById(id);

        return true;
    }

    public ClienteModel findByNameAndEmail(String name, String email) {

        Optional<List<ClienteModel>> listClienteModel = clienteRepository.findByNameOrEmail(name, email);

        if (listClienteModel.isPresent()) {


            return listClienteModel.stream().findFirst().get().get(0);
        } else {
            throw new RecursoNaoEncontradoException("Usuário não encontrado");
        }

    }

    public ClienteDto buscarPorId(Long id) {

        Optional<ClienteModel> clienteModel = clienteRepository.buscaPorId(id);

        if (clienteModel.isPresent())
        {
            return new ClienteDto(clienteModel);
        }else {
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }


    }
}