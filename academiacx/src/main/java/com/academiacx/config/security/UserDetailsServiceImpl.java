package com.academiacx.config.security;

import com.academiacx.model.ClienteModel;
import com.academiacx.repository.ClienteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final ClienteRepository clienteRepository;

    public UserDetailsServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClienteModel clienteModel = clienteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Cliente com o username: " + username + " não foi encontrado!"));

        return clienteModel;
    }
}
