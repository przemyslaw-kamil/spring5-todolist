package com.przemyslaw_kamil.todolist.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    public Item item;


    @Before
    public void setUp() throws Exception {
       item = new Item();
    }

    @Test
    public void setDetails() {
        //given
        Details details = new Details();
        details.setNotes("Note");

        //when
        item.setDetails(details);

        //then
        assertEquals(details, item.getDetails());
        assertEquals(item,item.getDetails().getItem());
    }
}