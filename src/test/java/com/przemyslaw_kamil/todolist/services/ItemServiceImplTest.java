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

    ItemCommandToItem itemCommandToItem;
    ItemToItemCommand itemToItemCommand;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        itemCommandToItem = new ItemCommandToItem();
        itemToItemCommand = new ItemToItemCommand();


        itemService = new ItemServiceImpl(itemRepository, itemToItemCommand, itemCommandToItem);
    }

    @Test
    public void getItems() {
    }

    @Test
    public void getItemByIdTest() throws Exception {
        //given
        Item item = new Item();
        item.setId(1L);
        Optional <Item> itemOptional = Optional.of(item);

        //when
        when(itemRepository.findById(anyLong())).thenReturn(itemOptional);
        Item itemReturned = itemService.findItemById(1L);

        //then
        assertNotNull("Null item returned", itemReturned);
        verify(itemRepository, times(1)).findById(anyLong());
        verify(itemRepository, never()).findAll();
    }

    @Test
    public void findCommandByIdTest() throws Exception {
        //given
        Item item = new Item();
        item.setId(1L);
        Optional <Item> itemOptional = Optional.of(item);

        //when
        when(itemRepository.findById(1L)).thenReturn(Optional.of(item));
        ItemCommand itemCommand = itemService.findCommandById(1L);

        //then
        assertNotNull("itemCommand is null", itemCommand);
        assertEquals(Long.valueOf(1L), itemCommand.getId());

    }

    @Test
    public void saveItemCommand() {
        //given
        Item item = new Item();
        item.setDescription("description");
        item.setId(15L);

        //when
        when(itemRepository.save(any())).thenReturn(item);
        ItemCommand itemCommand = itemService.saveItemCommand(itemToItemCommand.convert(item));

        //then
        assertNotNull(itemCommand);
        assertEquals(itemCommand.getDescription(), item.getDescription());
        assertEquals(itemCommand.getId(), item.getId());

    }
}


















