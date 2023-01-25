package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ErroInternoException;
import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.model.EnderecoModel;
import com.demo.academiacx.model.dto.ClienteDto;
import com.demo.academiacx.model.dto.ProdutoDto;
import com.demo.academiacx.repository.ClienteRepostory;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService {

    private ClienteRepostory clienteRepository;
    private final ModelMapper modelMapper;

    public ClienteService(ClienteRepostory clienteRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }

    public List<ClienteDto> findAll() {
        List<ClienteModel> ClienteModels = clienteRepository.findAll();

        return modelMapper.map(ClienteModels, new TypeToken<List<ClienteDto>>() {
        }.getType());
    }

    public ClienteDto findById(ClienteModel ClienteModel) {

        if (ClienteModel == null) {
            throw new ParametroInvalidoException("A Cliente Model deve informada");

        }

        if (ClienteModel.getId() == null) {
            throw new ParametroInvalidoException("A Cliente Model deve conter um id");

        }

        try {
            ClienteModel = clienteRepository.findById(ClienteModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(ClienteModel, ClienteDto.class);
    }

    public ClienteDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        ClienteModel ClienteModel = new ClienteModel();
        try {
            ClienteModel = clienteRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(ClienteModel, ClienteDto.class);
    }

    public ClienteDto insert(ClienteDto clienteDto) {

        ClienteDto result = new ClienteDto(clienteRepository.save(new ClienteModel(clienteDto)));

        return result;
    }

    public ClienteModel update(ClienteModel ClienteModel) {

        findById(ClienteModel);


        return clienteRepository.save(ClienteModel);
    }

    public ClienteModel findModelById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        ClienteModel ClienteModel = new ClienteModel();
        try {
            ClienteModel = clienteRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return ClienteModel;
    }

    public boolean delete(Long id) {

        if (findById(id) != null) {
            ClienteModel clienteModel = findModelById(id);
            try {
                clienteRepository.delete(clienteModel);
            } catch (Exception e) {
                throw new ErroInternoException("Erro interno ao deletar", e);
            }
            return true;
        }
        return false;
    }
}
