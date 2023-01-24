package com.example.ecommerce.config.security;

import com.example.ecommerce.model.ItemModel;
import com.example.ecommerce.repository.ItemRepository;
import com.example.ecommerce.service.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemModel loadItemByID(Long id) throws ItemNotFoundException {
        ItemModel itemModel = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item não encontrado com ID: " + id));

        return itemModel;
    }
}
