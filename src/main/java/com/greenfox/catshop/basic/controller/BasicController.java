package com.greenfox.catshop.basic.controller;

import com.greenfox.catshop.basic.model.BasicDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class BasicController {

    @GetMapping("")
    public BasicDTO getBasicInfo() {
        BasicDTO basicDTO = new BasicDTO("Backend works fine!", "UP",
                "UP", "Created by Dominik Balogh and Balázs Varga");
        return basicDTO;
    }

    @GetMapping("/api/admin")
    public ModelAndView openAdminPage() {
        return new ModelAndView("redirect:" + "http://be9a1de2.ngrok.io/admin");
    }
}
