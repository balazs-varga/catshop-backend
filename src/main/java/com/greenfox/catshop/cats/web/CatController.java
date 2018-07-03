package com.greenfox.catshop.cats.web;

import com.greenfox.catshop.cats.error.CatNotFoundException;
import com.greenfox.catshop.cats.model.CatDTO;
import com.greenfox.catshop.cats.service.CatService;
import com.greenfox.catshop.error.ErrorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CatController {

  @Autowired
  CatService catService;

  @GetMapping("/cats")
  public List<CatDTO> listCats() {
    return catService.listCats();
  }

  @GetMapping("/cats/{id}")
  public CatDTO getCat(@PathVariable("id") Long id) {
    return catService.getCat(id);
  }

  @ExceptionHandler({CatNotFoundException.class})
  public ErrorResource handlePermissionException(HttpServletResponse response) {
    response.setStatus(403);
    return new ErrorResource(
            "Cat not found.",
            HttpStatus.BAD_REQUEST);
  }
}