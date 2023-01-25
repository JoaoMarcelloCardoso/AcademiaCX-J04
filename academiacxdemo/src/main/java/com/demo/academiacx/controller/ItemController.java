package com.demo.academiacx.controller;

import com.demo.academiacx.model.CarrinhoModel;
import com.demo.academiacx.model.ItemModel;
import com.demo.academiacx.model.dto.ItemDto;
import com.demo.academiacx.repository.ItemRepository;
import com.demo.academiacx.services.ItemService;
import com.demo.academiacx.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<ItemDto> response = itemService.findAll();
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ItemDto findById(@PathVariable Long id){
        return itemService.findById(id);
    }

    @PostMapping("/save")
    public ItemDto insert(@RequestBody ItemModel itemModel){

        return itemService.insert(itemModel);
    }

    @PutMapping("/update")
    public ItemModel update(@RequestBody ItemDto itemDto){

        return itemService.update(itemDto);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id){

        return itemService.delete(id);
    }




}
