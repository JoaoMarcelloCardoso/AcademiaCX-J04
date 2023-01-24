package com.example.ecommerce.config.security;

import com.example.ecommerce.model.EnderecoModel;
import com.example.ecommerce.repository.EnderecoRepository;
import com.example.ecommerce.service.EnderecoService;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    final EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public EnderecoModel loadEnderecoByID(Long id) throws EnderecoNotFoundException {
        EnderecoModel enderecoModel = enderecoRepository.findById(id)
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço não encontrado com ID: " + id));

        return enderecoModel;
    }
}