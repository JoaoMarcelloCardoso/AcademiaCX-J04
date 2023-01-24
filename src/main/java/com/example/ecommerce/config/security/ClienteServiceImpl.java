package com.example.ecommerce.config.security;

import com.example.ecommerce.model.ClienteModel;
import com.example.ecommerce.repository.ClienteRepository;
import com.example.ecommerce.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteModel loadClienteByCPF(String cpf) throws ClienteNotFoundException {
        ClienteModel clienteModel = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado com CPF: " + cpf));

        return clienteModel;
    }
}
