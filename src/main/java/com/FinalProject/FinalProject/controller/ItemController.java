package com.FinalProject.FinalProject.controller;

import com.FinalProject.FinalProject.model.Item;
import com.FinalProject.FinalProject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/getAll")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PutMapping("/update")
    public Item updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }
}
