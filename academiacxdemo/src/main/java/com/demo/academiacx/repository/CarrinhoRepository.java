package com.demo.academiacx.repository;

import com.demo.academiacx.model.CarrinhoModel;
import com.demo.academiacx.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<CarrinhoModel, Long> {

    Optional<CarrinhoModel> findByUsername(String username);
}
