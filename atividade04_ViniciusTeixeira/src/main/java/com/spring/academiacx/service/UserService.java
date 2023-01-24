package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.ProdutoModel;
import com.spring.academiacx.model.UserModel;
import com.spring.academiacx.model.dto.UserDto;
import com.spring.academiacx.repository.ProdutoRepository;
import com.spring.academiacx.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> findAll() {
        List<UserModel> userDtos = userRepository.findAll();

        return userDtos;
    }

    public UserModel findById(UserModel userDto) {

        if (userDto == null) {
            throw new ParametroInvalidoException("O Model Produto deve informado");

        }

        if (userDto.getId() == null) {
            throw new ParametroInvalidoException("O Model Produto deve conter um id");

        }

        try {
            userDto = userRepository.findById(userDto.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return userDto;
    }

    public UserModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        UserModel userDto = new UserModel();
        try {
            userDto = userRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return userDto;
    }

    public UserModel insert(UserModel userDto) {
        userDto.setId(null);

        UserModel result = userRepository.save(userDto);

        return result;
    }

    public UserModel update(UserModel userDto) {

        findById(userDto);


        return userRepository.save(userDto);
    }

    public boolean delete(Long id) {

        findById(id);

        userRepository.deleteById(id);

        return true;
    }
}




