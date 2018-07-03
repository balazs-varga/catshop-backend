package com.greenfox.catshop.basic.controller;

import com.greenfox.catshop.basic.model.BasicDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class BasicController {

    @GetMapping
    public BasicDTO getBasicInfo() {
        BasicDTO basicDTO = new BasicDTO("Backend works fine!", "UP", "UP", "Created by the BackEnd👑 and his sluts.");

        return basicDTO;
    }

    @GetMapping("api")
    public ModelAndView method() {
        return new ModelAndView("redirect:" + "https://google.com");

    }
}
