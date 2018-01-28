package com.przemyslaw_kamil.todolist.converters;

import com.przemyslaw_kamil.todolist.commands.ItemCommand;
import com.przemyslaw_kamil.todolist.domain.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemToItemCommand {


    public ItemCommand convert (Item source){

        if(source==null){
            return null;
        }

        final ItemCommand command = new ItemCommand();
        command.setId(source.getId());
        command.setColorProject(source.getColorProject());
        command.setDescription(source.getDescription());
        command.setDetails(source.getDetails());
        command.setDeadline(source.getDeadline());


        return command;
    }


}
