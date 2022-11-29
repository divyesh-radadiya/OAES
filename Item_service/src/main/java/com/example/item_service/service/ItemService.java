package com.example.item_service.service;


import com.example.item_service.entity.Item;

import java.util.List;
import java.util.Map;

public interface ItemService {
    public Item getItem(Map<String,String> payload);
    public List<Item> getRandomItem(Map<String,String> payload);
}

