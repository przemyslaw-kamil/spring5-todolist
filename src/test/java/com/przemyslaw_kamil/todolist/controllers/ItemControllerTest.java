package com.przemyslaw_kamil.todolist.controllers;

import com.przemyslaw_kamil.todolist.domain.Item;
import com.przemyslaw_kamil.todolist.repositories.ItemRepository;
import com.przemyslaw_kamil.todolist.services.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ItemControllerTest {

    ItemController itemController;
    @Mock
    ItemService itemService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
   itemController= new ItemController(itemService);
    }

    @Test
    public void showItem() throws Exception{

        //given
        Item item = new Item();
        item.setId(1L);

        //when
        when(itemService.findItemById(anyLong())).thenReturn(item);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();

        //then
        mockMvc.perform(get("/item/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("item/show"))
                .andExpect(model().attributeExists("items"))
                .andExpect(model().attributeExists("item"));



    }
}