package com.example;

import com.fasterxml.jackson.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import java.util.function.Supplier;
import java.util.*;


@RestController
public class ItemApi {

    public ItemApi() {
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createitem")
    public Item Item(@RequestBody Item postmanItem) {
        service.createItem(postmanItem);
        return postmanItem;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<Item> searchResult(@RequestParam String searchTerm){
        List<Item> results= com.example.FuzzySearch.singleton().containsSearch(searchTerm);
        return results; 
    }

        @Autowired
        private ItemService service;
}
    
    
