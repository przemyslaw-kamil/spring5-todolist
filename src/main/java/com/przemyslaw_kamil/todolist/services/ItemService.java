package com.przemyslaw_kamil.todolist.services;

import com.przemyslaw_kamil.todolist.domain.Item;

import java.util.Set;


public interface ItemService {

    Set<Item> getItems();
    Item findItemById(Long id);

}
