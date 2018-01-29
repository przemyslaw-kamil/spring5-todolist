package com.przemyslaw_kamil.todolist.services;

import com.przemyslaw_kamil.todolist.commands.ItemCommand;
import com.przemyslaw_kamil.todolist.domain.Item;

import java.util.Set;


public interface ItemService {

    Set<Item> getItems();
    Item findItemById(Long id);
    ItemCommand findCommandById(Long id);
    ItemCommand saveItemCommand(ItemCommand command);
    void deleteById(Long id);

}
