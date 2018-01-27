package com.przemyslaw_kamil.todolist.bootstrap;


import com.przemyslaw_kamil.todolist.domain.Item;
import com.przemyslaw_kamil.todolist.repositories.ItemRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by jt on 6/13/17.
 */
@Component
public class ItemBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ItemRepository itemRepository;

    public ItemBootstrap(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        itemRepository.saveAll(getItems());

    }

    private List<Item> getItems() {

        List<Item> items = new ArrayList<>();

        //
        Item item1 = new Item ();
        item1.setDescription("My first to do item");
        item1.getDetails().setNotes("I should do something");
        item1.setDeadline(LocalDate.of(2017,12,25));


        Item item2 = new Item ();
        item2.setDescription("My second to do item");
        item2.getDetails().setNotes("I should do something");
        item2.setDeadline(LocalDate.of(2018,1,12));


        Item item3 = new Item ();
        item3.setDescription("My next to do item");
        item3.getDetails().setNotes("I should do something");
        item3.setDeadline(LocalDate.of(2018,1,10));

        //add to return list
        items.add(item1);
        items.add(item2);
        items.add(item3);

        return items;
    }
}
