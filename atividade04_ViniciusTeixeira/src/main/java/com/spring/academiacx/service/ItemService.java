package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.ItemModel;
import com.spring.academiacx.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemModel> findAll() {
        List<ItemModel> itemDtos = itemRepository.findAll();

        return itemDtos;
    }

    public ItemModel findById(ItemModel itemDto) {

        if (itemDto == null) {
            throw new ParametroInvalidoException("O Model Item deve informado");

        }

        if (itemDto.getId() == null) {
            throw new ParametroInvalidoException("O Model Item deve conter um id");

        }

        try {
            itemDto = itemRepository.findById(itemDto.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return itemDto;
    }

    public ItemModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        ItemModel itemDto = new ItemModel();
        try {
            itemDto = itemRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return itemDto;
    }

    public ItemModel insert(ItemModel itemDto) {
        itemDto.setId(null);

        ItemModel result = itemRepository.save(itemDto);

        return result;
    }

    public ItemModel update(ItemModel itemDto) {

        findById(itemDto);


        return itemRepository.save(itemDto);
    }

    public boolean delete(Long id) {

        findById(id);

        itemRepository.deleteById(id);

        return true;
    }
}


