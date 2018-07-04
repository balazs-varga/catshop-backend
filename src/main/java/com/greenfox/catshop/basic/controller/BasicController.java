package com.greenfox.catshop.basic.controller;

import com.greenfox.catshop.basic.model.BasicDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class BasicController {

    @GetMapping("")
    public BasicDTO getBasicInfo() {
        BasicDTO basicDTO = new BasicDTO("Backend works fine!", "UP",
                "UP", "Created by the BackEnd👑 and his sluts.");

        return basicDTO;
    }

    @GetMapping("/search/{search}")
    public ModelAndView method(@PathVariable("search") String search) {
        return new ModelAndView("redirect:" + "https://www.gyakorikerdesek.hu/kereses.php?keres=" + search);
    }
}
