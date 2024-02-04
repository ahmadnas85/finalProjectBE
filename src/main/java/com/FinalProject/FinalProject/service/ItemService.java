package com.FinalProject.FinalProject.service;

import com.FinalProject.FinalProject.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    Item updateItem(Item item);
}
