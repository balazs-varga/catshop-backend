package com.greenfox.catshop.cats.web;

import com.greenfox.catshop.cats.error.CartElementNotFound;
import com.greenfox.catshop.cats.model.CartDTO;
import com.greenfox.catshop.cats.model.CatDTO;
import com.greenfox.catshop.cats.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping("/empty-cart")
    public void deleteCart(@RequestBody() CartDTO cartDTO) {
        cartService.emptyCart(cartDTO);
    }

    @PostMapping("/sold")
    public void soldCart(@RequestBody() CartDTO cartDTO) {
        cartService.soldCart(cartDTO);
    }


    @ExceptionHandler({CartElementNotFound.class})
    public ModelAndView handleNotFoundException() {
        return new ModelAndView("redirect:" + "https://www.gyakorikerdesek.hu/kereses.php?keres=" + "Miért+hibás+a+frontend?");
    }
}
