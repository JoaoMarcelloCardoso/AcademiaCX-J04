package com.example.ecommerce.config.security;

import com.example.ecommerce.model.PrecoModel;
import com.example.ecommerce.repository.PrecoRepository;
import com.example.ecommerce.service.PrecoService;
import org.springframework.stereotype.Service;

@Service
public class PrecoServiceImpl implements PrecoService {

    final PrecoRepository precoRepository;

    public PrecoServiceImpl(PrecoRepository precoRepository) {
        this.precoRepository = precoRepository;
    }

    @Override
    public PrecoModel loadPrecoByID(Long id) throws PrecoNotFoundException {
        PrecoModel precoModel = precoRepository.findById(id)
                .orElseThrow(() -> new PrecoNotFoundException("Preço não encontrado com ID: " + id));

        return precoModel;
    }
}
