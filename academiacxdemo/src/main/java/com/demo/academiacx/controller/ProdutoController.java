package com.demo.academiacx.controller;

import com.demo.academiacx.model.CarrinhoModel;
import com.demo.academiacx.model.ProdutoModel;
import com.demo.academiacx.model.dto.ProdutoDto;
import com.demo.academiacx.repository.ProdutoRepository;
import com.demo.academiacx.services.ProdutoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<ProdutoDto> response = produtoService.findAll();
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ProdutoDto findById(@PathVariable Long id){
        return produtoService.findById(id);
    }

    @PostMapping("/save")
    public ProdutoDto insert(@RequestBody ProdutoDto produtoDto) {

        return produtoService.insert(produtoDto);
    }

    @PutMapping("/update")
    public ProdutoModel update(@RequestBody ProdutoModel produtoModel){

        return produtoService.update(produtoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id){

        return produtoService.delete(id);
    }


}
