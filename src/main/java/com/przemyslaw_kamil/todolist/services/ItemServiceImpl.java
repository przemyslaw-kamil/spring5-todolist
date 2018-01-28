package com.przemyslaw_kamil.todolist.services;

import com.przemyslaw_kamil.todolist.commands.ItemCommand;
import com.przemyslaw_kamil.todolist.converters.ItemCommandToItem;
import com.przemyslaw_kamil.todolist.converters.ItemToItemCommand;
import com.przemyslaw_kamil.todolist.domain.Item;
import com.przemyslaw_kamil.todolist.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemToItemCommand itemToItemCommand;
    private final ItemCommandToItem itemCommandToItem;

    public ItemServiceImpl(ItemRepository itemRepository, ItemToItemCommand itemToItemCommand, ItemCommandToItem itemCommandToItem) {
        this.itemRepository = itemRepository;
        this.itemToItemCommand = itemToItemCommand;
        this.itemCommandToItem = itemCommandToItem;
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

    @Override
    public ItemCommand findCommandById(Long id) {

       return itemToItemCommand.convert(findItemById(id));
    }
}
