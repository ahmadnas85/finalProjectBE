package com.FinalProject.FinalProject.repository;

import com.FinalProject.FinalProject.model.Item;

import java.util.List;

public interface ItemRepository {
    List<Item> getAllItems();

    Item updateItem(Item item);
}
