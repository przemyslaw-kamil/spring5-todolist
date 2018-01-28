package com.przemyslaw_kamil.todolist.converters;

import com.przemyslaw_kamil.todolist.commands.ItemCommand;
import com.przemyslaw_kamil.todolist.domain.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemCommandToItem {

    public Item convert (ItemCommand source){
       if (source==null){
           return null;
       }
       final Item item = new Item();

        item.setId(source.getId());
        item.setColorProject(source.getColorProject());
        item.setDescription(source.getDescription());
        item.setDetails(source.getDetails());
        item.setDeadline(source.getDeadline());

        return item;
    }
}
