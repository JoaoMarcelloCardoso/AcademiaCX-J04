package com.demo.academiacx.repository;

import com.demo.academiacx.model.PrecoModel;
import com.demo.academiacx.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    Optional<ProdutoModel> findByUsername(String username);
}
