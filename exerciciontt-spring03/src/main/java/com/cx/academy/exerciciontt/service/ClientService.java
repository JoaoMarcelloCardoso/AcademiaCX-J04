package com.cx.academy.exerciciontt.service;

import com.cx.academy.exerciciontt.handler.exceptions.ErroDeFormatoException;
import com.cx.academy.exerciciontt.handler.exceptions.ParametroInvalidoException;
import com.cx.academy.exerciciontt.handler.exceptions.RecursoNaoEncontradoExeception;
import com.cx.academy.exerciciontt.handler.exceptions.SemConteudoException;
import com.cx.academy.exerciciontt.model.AddressModel;
import com.cx.academy.exerciciontt.model.CartModel;
import com.cx.academy.exerciciontt.model.ClientModel;
import com.cx.academy.exerciciontt.model.dto.request.ClientDtoRequest;
import com.cx.academy.exerciciontt.model.dto.response.ClientDtoResponse;
import com.cx.academy.exerciciontt.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    private final ModelMapper modelMapper;

    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;

    }

    public List<ClientDtoResponse> findAll() {
        try {
            List<ClientModel> clientList = clientRepository.findAll();
            if(clientList.isEmpty()) {
                throw new SemConteudoException("Não há conteúdo no endpoint client");
            }
            return modelMapper.map(clientList, new TypeToken<List<ClientDtoResponse>>() {}.getType());
        } catch (Exception e){
            throw new ErroDeFormatoException("Erro ao buscar clientes");
        }
    }

    public ClientDtoResponse findById(Long id) {
        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        try {
            ClientModel clientModel = clientRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoExeception("Cliente não encontrado com o id informado"));
        return modelMapper.map(clientModel, ClientDtoResponse.class);
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar cliente pelo id");
        }
    }

    public ClientDtoResponse findById(ClientModel clientModel) {
        if (clientModel == null) {
            throw new ParametroInvalidoException("A Client Model deve ser informada");
        }

        if (clientModel.getId() == null) {
            throw new ParametroInvalidoException("A Client Model deve conter um id");
        }

        try {
            ClientModel client = clientRepository.findById(clientModel.getId()).orElseThrow(() -> new RecursoNaoEncontradoExeception("Cliente não encontrado com o id informado"));
            return modelMapper.map(client, ClientDtoResponse.class);
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar cliente pelo id");
        }
    }


    public ClientDtoResponse insert(ClientDtoRequest clientDtoRequest) {

        ClientModel clientModel = modelMapper.map(clientDtoRequest, ClientModel.class);
        clientModel.setPassword(new BCryptPasswordEncoder().encode(clientDtoRequest.getPassword()));
        clientRepository.save(clientModel);
        return  modelMapper.map(clientModel, ClientDtoResponse.class) ;
    }


    public ClientDtoResponse update(ClientModel clientModel) {
        if(!clientRepository.existsById(clientModel.getId())) {
            throw new RecursoNaoEncontradoExeception("Não existe cliente com o id informado");
        }

        try {

            clientRepository.save(clientModel);
            return modelMapper.map(clientModel, ClientDtoResponse.class);
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao atualizar cliente");
        }
    }

    public boolean delete(Long id) {
        if(id == null || !clientRepository.existsById(id)) {
            throw new RecursoNaoEncontradoExeception("Não existe cliente com o id informado");
        }
        try {
            clientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao deletar cliente");
        }
}}