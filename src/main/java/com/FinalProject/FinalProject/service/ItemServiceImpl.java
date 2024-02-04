package com.FinalProject.FinalProject.service;

import com.FinalProject.FinalProject.model.Item;
import com.FinalProject.FinalProject.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }
    @Override
    public Item updateItem(Item item) {
        return itemRepository.updateItem(item);
    }
}
