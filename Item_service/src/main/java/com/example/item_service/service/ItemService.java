package com.example.item_service.service;


import com.example.item_service.entity.Item;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public interface ItemService {

    public Item getItem(Map<String,String> payload);
    public List<Item> getRandomItem(JSONObject payload);
}

