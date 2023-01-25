package com.demo.academiacx.controller;

import java.util.List;
import com.demo.academiacx.model.CarrinhoModel;
import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.model.dto.CarrinhoDto;
import com.demo.academiacx.repository.CarrinhoRepository;
import com.demo.academiacx.services.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cart")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<CarrinhoDto> response = carrinhoService.findAll();
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public CarrinhoDto findById(@PathVariable Long id){
        return carrinhoService.findById(id);
    }

    @PostMapping("/save")
    public CarrinhoDto insert(@RequestBody CarrinhoDto carrinhoDto){
        return carrinhoService.insert(carrinhoDto);
    }

    @PutMapping("/update")
    public CarrinhoModel update(@RequestBody CarrinhoModel carrinhoModel){

        return carrinhoService.update(carrinhoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id){

        return carrinhoService.delete(id);
    }


}

