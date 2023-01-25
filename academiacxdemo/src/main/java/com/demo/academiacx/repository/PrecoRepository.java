package com.demo.academiacx.repository;

import com.demo.academiacx.model.ItemModel;
import com.demo.academiacx.model.PrecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrecoRepository extends JpaRepository<PrecoModel, Long> {

    Optional<PrecoModel> findByUsername(String username);

}
