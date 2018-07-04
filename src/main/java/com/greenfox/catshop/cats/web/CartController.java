package com.greenfox.catshop.cats.web;

import com.greenfox.catshop.cats.error.CartElementNotFound;
import com.greenfox.catshop.cats.model.CartDTO;
import com.greenfox.catshop.cats.model.CatDTO;
import com.greenfox.catshop.cats.service.CartService;
import com.greenfox.catshop.error.ErrorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    @PostMapping("/empty-cart")
    public void soldCart(@RequestBody() CartDTO cartDTO) {
        cartService.soldCart(cartDTO);
    }


    @ExceptionHandler({CartElementNotFound.class})
    public ErrorResource handleCartElementNotFoundException(HttpServletResponse response) {
        response.setStatus(404);
        return new ErrorResource(
                "Cart element not found.",
                HttpStatus.BAD_REQUEST);
    }
}
