package com.przemyslaw_kamil.todolist.services;

import com.przemyslaw_kamil.todolist.commands.ItemCommand;
import com.przemyslaw_kamil.todolist.converters.ItemCommandToItem;
import com.przemyslaw_kamil.todolist.converters.ItemToItemCommand;
import com.przemyslaw_kamil.todolist.domain.Item;
import com.przemyslaw_kamil.todolist.repositories.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTestIT {

    public static final String NEW_DESCRIPTION = "New Description";

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemCommandToItem itemCommandToItem;

    @Autowired
    ItemToItemCommand itemToItemCommand;

    @Transactional
    @Test
    public void testSaveOfDescription() throws Exception {
        //given
        Iterable<Item> items = itemRepository.findAll();
        Item testItem = items.iterator().next();

        ItemCommand testItemCommand = itemToItemCommand.convert(testItem);

        //when
        testItemCommand.setDescription(NEW_DESCRIPTION);
        ItemCommand savedItemCommand = itemService.saveItemCommand(testItemCommand);

        //then
        assertEquals(NEW_DESCRIPTION, savedItemCommand.getDescription());
        assertEquals(testItem.getId(), savedItemCommand.getId());
    }
}



