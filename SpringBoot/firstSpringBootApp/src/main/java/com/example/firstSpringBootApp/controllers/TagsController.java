package com.example.firstSpringBootApp.controllers;


import com.example.firstSpringBootApp.data.Tag;
import com.example.firstSpringBootApp.data.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/bookshop")
public class TagsController {

    private TagService tagService;
    @Autowired
    public TagsController(TagService tagService) {
        this.tagService = tagService;
    }


}
