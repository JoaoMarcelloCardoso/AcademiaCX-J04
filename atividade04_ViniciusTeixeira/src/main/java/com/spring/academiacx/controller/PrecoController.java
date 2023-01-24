package com.spring.academiacx.controller;

import com.spring.academiacx.model.PrecoModel;
import com.spring.academiacx.service.PrecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/preco")
public class PrecoController {

    @Autowired
    private PrecoService precoService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<PrecoModel> response = precoService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public PrecoModel findById(@PathVariable Long id) {

        return precoService.findById(id);
    }

    @PostMapping("/save")
    public PrecoModel insert(@RequestBody PrecoModel precoDto) {

        return precoService.insert(precoDto);
    }


    @PutMapping("/update")
    public PrecoModel update(@RequestBody PrecoModel precoDto) {

        return precoService.update(precoDto);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return precoService.delete(id);
    }


}





