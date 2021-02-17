package com.warehouse.user.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse.user.Model.Item;
import com.warehouse.user.Model.Log;
import com.warehouse.user.Repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ObjectMapper objectMapper;

    //Get item
    public Item getItem(String dep, int id) {
        return itemRepo.getItem(dep, id);
    }

    //Add item
    public void addItem(String dep, Item item) {
        itemRepo.addItem(dep, item);
    }
    //Add item
    public List<Item> getAllItems(String dep) {
        return itemRepo.getAllItems(dep);
    }

    //Update item
    public void updateItem(String dep, Item item) {
        itemRepo.updateItem(dep, item);
    }

    public void sendItem(String dep, Item item) throws IOException {
        itemRepo.sendItem(dep, item);
    }

    public List<Item> searchItems(String dep, String value) {
        return itemRepo.searchItems(dep, value);
    }

    public List<Log> getLogs(String dep, int id) {
        return itemRepo.getLog(dep, id);
    }

}
