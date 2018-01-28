package com.przemyslaw_kamil.todolist.converters;

import com.przemyslaw_kamil.todolist.commands.ItemCommand;
import com.przemyslaw_kamil.todolist.domain.ColorProject;
import com.przemyslaw_kamil.todolist.domain.Item;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ItemCommandToItemTest {

    ItemCommandToItem itemCommandToItem;

    @Before
    public void setUp() throws Exception {
    itemCommandToItem = new ItemCommandToItem();
    }

    @Test
    public void convert() {
            //given

        ItemCommand source = new ItemCommand();
            source.setId(1L);
            source.setColorProject(ColorProject.Blue);
            source.setDeadline(LocalDate.of(2018,01,28));
            source.getDetails().setNotes("Notes");
            source.setDescription("Description");

            //when
            Item item =  itemCommandToItem.convert(source);

            //then
            assertEquals(source.getDetails(), item.getDetails());
            assertEquals(source.getColorProject(), item.getColorProject());
            assertEquals(source.getDescription(), item.getDescription());
            assertEquals(source.getDeadline(), item.getDeadline());
            assertEquals(source.getId(),item.getId());
        }
    }
