package com.przemyslaw_kamil.todolist.converters;

import com.przemyslaw_kamil.todolist.commands.ItemCommand;
import com.przemyslaw_kamil.todolist.domain.ColorProject;
import com.przemyslaw_kamil.todolist.domain.Details;
import com.przemyslaw_kamil.todolist.domain.Item;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ItemToItemCommandTest {
    ItemToItemCommand itemToItemCommand;

    @Before
    public void setUp() throws Exception {
        itemToItemCommand = new ItemToItemCommand();
    }

    @Test
    public void convert() {
        //given
        Item source = new Item();
        source.setId(1L);
        source.setColorProject(ColorProject.Blue);
//        source.setDeadline(LocalDate.of(2018,01,28));
        source.getDetails().setNotes("Notes");
        source.setDescription("Description");

        //when
        ItemCommand command =  itemToItemCommand.convert(source);

        //then
        assertEquals(source.getDetails(), command.getDetails());
        assertEquals(source.getColorProject(), command.getColorProject());
        assertEquals(source.getDescription(), command.getDescription());
        assertEquals(source.getDeadline(), command.getDeadline());
        assertEquals(source.getId(),command.getId());
    }


}