package com.example.ecommerce.service;

import com.example.ecommerce.handler.exceptions.RecursoNaoEncontradoException;
import com.example.ecommerce.model.ItemModel;
import com.example.ecommerce.model.dto.ItemDto;
import com.example.ecommerce.repository.ItemRepository;
import org.springframework.stereotype.Service;


@Service
public class ItemService {

    private final ItemRepository itemRepository;

    private final ModelMapper modelMapper;

    public ItemService(ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    public ItemDto findById(Long id) {
        ItemModel itemModel = itemRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Item não encontrado com id: " + id));
        return new ItemDto(itemModel);
    }

    public ItemDto insert(ItemDto itemDto) {
        itemDto.setId(null);
        ItemModel itemModel = new ItemModel(itemDto);
        itemModel = itemRepository.save(itemModel);
        return new ItemDto(itemModel);
    }

    public ItemDto update(ItemDto itemDto) {
        ItemModel itemModel = itemRepository.findById(itemDto.getId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Item não encontrado com id: " + itemDto.getId()));
        itemModel.setQuantidade(itemDto.getQuantidade());
        itemModel = itemRepository.save(itemModel);
        return new ItemDto(itemModel);
    }

    public boolean delete(Long id) {
        findById(id);
        itemRepository.deleteById(id);
        return true;
    }
}