package com.greenfox.catshop.cats.web;

import com.greenfox.catshop.cats.error.CatNotFoundException;
import com.greenfox.catshop.cats.model.CatDTO;
import com.greenfox.catshop.cats.service.CatService;
import com.greenfox.catshop.cats.util.Fluffiness;
import com.greenfox.catshop.error.ErrorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CatController {

    @Autowired
    CatService catService;

    @GetMapping({"/cats"})
    public List<CatDTO> fluffinessQuery(@RequestParam(name = "fluffiness", required = false) String fluffiness) {
        if (fluffiness == null) {
            return catService.listCats();
        } else {
            List<CatDTO> catDTOList = new ArrayList<>();

            if (fluffiness.equals(Fluffiness.SUPER_FLUFFY.toString()) || fluffiness.equals(Fluffiness.SEMI_FLUFFY.toString())
                    || fluffiness.equals(Fluffiness.SPECIAL_CARE.toString())) {
                catDTOList = catService.listCatsByFluffiness(fluffiness);
            } else {
                throw new CatNotFoundException("Cat not found.");
            }

            if (catDTOList == null) {
                throw new CatNotFoundException("Cat not found.");
            } else {
                return catDTOList;
            }
        }
    }

    @GetMapping("/cats/name/{name}")
    public CatDTO getCat(@PathVariable("name") String name) {
        return catService.getCatByName(name);
    }

    @GetMapping("/cats/search/{name}")
    public List<CatDTO> searchCatByName(@PathVariable("name") String name) {
        return catService.searchCatsByName(name);
    }

    @DeleteMapping("/cats/{id}")
    public void deleteCatById(@PathVariable("id") Long id) {
        catService.deleteCat(id);
    }

    @ExceptionHandler({CatNotFoundException.class})
    public ErrorResource handlePermissionException(HttpServletResponse response) {
        response.setStatus(404);
        return new ErrorResource(
                "Cat not found.",
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/cats")
    public ResponseEntity addNewCat(@RequestBody() CatDTO catDTO) {
        try {
            catService.addNewCat(catDTO);
            return new ResponseEntity("OK", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/cats/{id}")
    public CatDTO voteForCat(@PathVariable("id") Long id, @RequestParam(name = "vote", required = true) String vote) {
        return catService.voteForCatById(id, vote);
    }

    @GetMapping("/cats/{id}")
    public CatDTO getCatById(@PathVariable("id") Long id) {
        return catService.getCatByID(id);
    }
}