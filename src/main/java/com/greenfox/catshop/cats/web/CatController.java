package com.greenfox.catshop.cats.web;

import com.greenfox.catshop.cats.model.CatDTO;
import com.greenfox.catshop.cats.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatController {

  @Autowired
  CatService catService;

  @GetMapping({"/api/cats"})
  public List<CatDTO> listCats() {
    return catService.listCats();
  }
}