package com.demo.academiacx.config.security;

import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.repository.ClienteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final ClienteRepository clienteRepository;

    public UserDetailsServiceImpl(ClienteRepository userRepository) {
        this.clienteRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClienteModel clienteModel = clienteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado com username: " + username));

        return clienteModel;
    }
}
