package com.greenfox.catshop.cats.web;

import com.greenfox.catshop.cats.model.CartDTO;
import com.greenfox.catshop.cats.model.CatDTO;
import com.greenfox.catshop.cats.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/cart")
    public List<CatDTO> createCart(@RequestBody() CartDTO cartDTO) {
        return cartService.createCart(cartDTO);
    }
}
