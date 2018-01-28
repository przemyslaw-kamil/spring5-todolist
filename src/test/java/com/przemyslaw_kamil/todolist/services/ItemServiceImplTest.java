package com.przemyslaw_kamil.todolist.services;

import com.przemyslaw_kamil.todolist.commands.ItemCommand;
import com.przemyslaw_kamil.todolist.converters.ItemCommandToItem;
import com.przemyslaw_kamil.todolist.converters.ItemToItemCommand;
import com.przemyslaw_kamil.todolist.domain.Item;
import com.przemyslaw_kamil.todolist.repositories.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class ItemServiceImplTest {

    ItemServiceImpl itemService;

    @Mock
    ItemRepository itemRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        itemService=new ItemServiceImpl(itemRepository,new ItemToItemCommand(), new ItemCommandToItem());


    }

    @Test
    public void getItems() {
    }

    @Test
    public void getItemByIdTest() throws Exception {
        //given
        Item item = new Item();
        item.setId(1L);
        Optional<Item> itemOptional = Optional.of(item);

        //when
        when(itemRepository.findById(anyLong())).thenReturn(itemOptional);
        Item itemReturned = itemService.findItemById(1L);

        //then
        assertNotNull("Null item returned", itemReturned);
        verify(itemRepository, times(1)).findById(anyLong());
        verify(itemRepository, never()).findAll();
    }

    @Test
    public void findCommandByIdTest() throws Exception{
        //given
        Item item = new Item();
        item.setId(1L);
        Optional<Item> itemOptional = Optional.of(item);

        //when
        when(itemRepository.findById(1L)).thenReturn(Optional.of(item));
        ItemCommand itemCommand = itemService.findCommandById(1L);

        //then
        assertNotNull("itemCommand is null", itemCommand);
        assertEquals(Long.valueOf(1L), itemCommand.getId());

    }

}