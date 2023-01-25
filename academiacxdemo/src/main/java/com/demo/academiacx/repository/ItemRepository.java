package com.demo.academiacx.repository;

import com.demo.academiacx.model.EnderecoModel;
import com.demo.academiacx.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemModel, Long> {

    Optional<ItemModel> findByUsername(String username);
}
