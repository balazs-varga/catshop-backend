package com.greenfox.catshop.cats.web;

import com.greenfox.catshop.cats.error.CatNotFoundException;
import com.greenfox.catshop.cats.model.CatDTO;
import com.greenfox.catshop.cats.service.CatService;
import com.greenfox.catshop.cats.util.Fluffiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CatController {

  @Autowired
  CatService catService;

  @GetMapping({"/api/cats"})
  public List<CatDTO> listCats() {
    return catService.listCats();
  }

  @GetMapping({"/api/cats"})
  public List<CatDTO> fluffinessQuery(@RequestParam(name = "fluffiness", required = false) String fluffiness) {
    List<CatDTO> catDTOList = new ArrayList<>();

    if (fluffiness.equals(Fluffiness.SUPER_FLUFFY.toString()) || fluffiness.equals(Fluffiness.SEMI_FLUFFY.toString())
            || fluffiness.equals(Fluffiness.SPECIAL_CARE.toString())) {
      catDTOList = catService.listCatsByFluffiness(fluffiness);
    }

    if (catDTOList == null) {
      throw new CatNotFoundException("Cat not found.");
    } else {
      return catDTOList;
    }
  }
}