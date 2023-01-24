package com.spring.academiacx.controller;

import com.spring.academiacx.model.CarrinhoModel;
import com.spring.academiacx.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carrinho")
public class CarrinhoController {
    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<CarrinhoModel> response = carrinhoService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public CarrinhoModel findById(@PathVariable Long id) {

        return carrinhoService.findById(id);
    }

    @PostMapping("/save")
    public CarrinhoModel insert(@RequestBody CarrinhoModel carrinhoDto) {

        return carrinhoService.insert(carrinhoDto);
    }


    @PutMapping("/update")
    public CarrinhoModel update(@RequestBody CarrinhoModel carrinhoDto) {

        return carrinhoService.update(carrinhoDto);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return carrinhoService.delete(id);
    }


}

