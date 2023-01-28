package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository= itemRepository;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public Item createItem(Item item){
        return itemRepository.save(item);
    }    
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Item> findAll(){
        List<Item> itemList= new ArrayList<>();
        Iterator<Item> itemIterator= itemRepository.findAll().iterator();
        itemIterator.forEachRemaining(itemList::add);
        return itemList;
        
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Item item){
        itemRepository.delete(item);
    }

}
