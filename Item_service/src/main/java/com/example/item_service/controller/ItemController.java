package com.example.item_service.controller;


import com.example.item_service.entity.Item;
import com.example.item_service.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/getItem", method = RequestMethod.GET)
    public ResponseEntity<?> getItem(@RequestBody Map<String,String> payload)
    {
        Item item = itemService.getItem(payload);
        return ResponseEntity.ok(item);
    }

    @RequestMapping(value = "/getRandomItem", method = RequestMethod.POST)
    public ResponseEntity<?> getRandomItem(@RequestBody Map<String,String> payload)
    {
        List<Item> item = itemService.getRandomItem(payload);
        return ResponseEntity.ok(item);
    }

}
