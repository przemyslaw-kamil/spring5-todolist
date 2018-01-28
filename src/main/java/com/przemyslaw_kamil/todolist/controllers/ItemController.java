package com.przemyslaw_kamil.todolist.controllers;

import com.przemyslaw_kamil.todolist.repositories.ItemRepository;
import com.przemyslaw_kamil.todolist.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("item/{id}/show")
    public String showItem(@PathVariable String id, Model model){
        model.addAttribute("items", itemService.getItems());
        model.addAttribute("item", itemService.findItemById(Long.valueOf(id)));

        return "item/show";



    }

}
