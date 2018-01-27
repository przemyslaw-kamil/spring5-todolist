package com.przemyslaw_kamil.todolist.services;

import com.przemyslaw_kamil.todolist.domain.Item;
import com.przemyslaw_kamil.todolist.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Set<Item> getItems() {

        Set<Item> itemSet = new HashSet <>();
       itemRepository.findAll().forEach(itemSet::add);
        return itemSet;
    }

    @Override
    public Item findItemById(Long id) {
        return itemRepository.findById(id).get();
    }
}
