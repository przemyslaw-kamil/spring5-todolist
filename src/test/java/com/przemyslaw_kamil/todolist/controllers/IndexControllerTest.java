package com.przemyslaw_kamil.todolist.controllers;

import com.przemyslaw_kamil.todolist.domain.Details;
import com.przemyslaw_kamil.todolist.domain.Item;
import com.przemyslaw_kamil.todolist.services.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {
    @Mock
    Model model;

    @Mock
    ItemService itemService;

    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(itemService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

    }

    @Test
    public void getIndexPage() {

        //given
        Set<Item> items = new HashSet <>();
        Item item1 = new Item();
        Item item2 = new Item();
        item2.setDetails(new Details());
        item1.setId(4L);
        items.add(item1);
        items.add(item2);

        //when
        when(itemService.getItems()).thenReturn(items);
        ArgumentCaptor<Set<Item>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //then

        assertEquals("index", indexController.getIndexPage(model) );
        verify(itemService, times(1)).getItems();
        verify(model, times(1)).addAttribute(anyString(), anySet());
        verify(model, times(1)).addAttribute(eq("items"), anySet());
        verify(model, times(1)).addAttribute(eq("items"),argumentCaptor.capture());
        Set<Item> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }


}