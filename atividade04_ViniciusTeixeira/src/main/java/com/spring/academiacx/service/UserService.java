package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.UserModel;
import com.spring.academiacx.model.dto.UserDto;
import com.spring.academiacx.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserDto> findAll() {
        List<UserModel> userModels = userRepository.findAll();


        return modelMapper.map(userModels, new TypeToken<List<UserDto>>() {
        }.getType());
    }

    public UserDto findById(UserModel userModel) {

        if (userModel == null) {
            throw new ParametroInvalidoException("A User Model deve informada");

        }

        if (userModel.getId() == null) {
            throw new ParametroInvalidoException("A User Model deve conter um id");

        }

        try {
            userModel = userRepository.findById(userModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }


        return modelMapper.map(userModel, UserDto.class);
    }


    public UserDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        UserModel userModel = new UserModel();
        try {
            userModel = userRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(userModel, UserDto.class);
    }

    public UserDto insert(UserDto userDto) {
        userDto.setId(null);

        UserDto result = new UserDto(userRepository.save(new UserModel(userDto)));

        return result;
    }

    public UserModel update(UserModel userModel) {

        return userRepository.save(userModel);
    }

    public boolean delete(Long id) {

        findById(id);

        userRepository.deleteById(id);

        return true;
    }



    public UserDto buscarPorId(Long id) {

        Optional<UserModel> userModel = userRepository.buscaPorId(id);

        if (userModel.isPresent())
        {
            return new UserDto(userModel.get());
        }else {
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }


    }
}