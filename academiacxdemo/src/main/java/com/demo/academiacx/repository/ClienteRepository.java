package com.demo.academiacx.repository;

import com.demo.academiacx.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    Optional<ClienteModel> findByNameAndEmail(String name, String email);

    Optional<ClienteModel> findByUsername(String username);

    Optional<List<ClienteModel>> findByNameOrEmail(String name, String email);

    //Querry Statica
    @Query("SELECT userModel FROM ClienteModel AS userModel WHERE userModel.id = ?1")
    Optional<ClienteModel> buscaPorId(Long id);


}