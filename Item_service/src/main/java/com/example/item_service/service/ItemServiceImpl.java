package com.example.item_service.service;

import com.example.item_service.entity.Item;
import com.example.item_service.repository.ItemRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "itemService")
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    public Item getItem(Map<String,String> payload){
        int itemId = Integer.parseInt(payload.get("itemId"));
        Item item = itemRepo.findByItemId(itemId);
        return item;
    }

    public List<Item> getRandomItem(JSONObject payload){
        int courseId = Integer.parseInt((String)payload.getString("courseId"));
        String category = (String) payload.getString("questionType");
        int numberOfQuestion = Integer.parseInt((String) payload.getString("numberOfQuestion"));
        List<Item> items = itemRepo.randomItem(courseId,category,numberOfQuestion);
        return items;
    }
}
