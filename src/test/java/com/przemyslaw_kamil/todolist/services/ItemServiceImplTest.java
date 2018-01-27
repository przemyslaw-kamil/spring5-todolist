package com.przemyslaw_kamil.todolist.services;

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
        itemService=new ItemServiceImpl(itemRepository);
    }

    @Test
    public void getItems() {
    }

    @Test
    public void getItemByIdTest() throws Exception {
        Item item = new Item();
        item.setId(1L);
        Optional<Item> itemOptional = Optional.of(item);

        when(itemRepository.findById(anyLong())).thenReturn(itemOptional);

        Item itemReturned = itemService.findItemById(1L);

        assertNotNull("Null item returned", itemReturned);
        verify(itemRepository, times(1)).findById(anyLong());
        verify(itemRepository, never()).findAll();
    }
}