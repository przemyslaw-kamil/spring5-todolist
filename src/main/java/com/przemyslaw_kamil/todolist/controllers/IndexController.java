package com.przemyslaw_kamil.todolist.controllers;

import com.przemyslaw_kamil.todolist.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 6/1/17.
 */

@Controller
public class IndexController {

    private final ItemService itemService;

    public IndexController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("items", itemService.getItems());

        return "index";
    }

}
