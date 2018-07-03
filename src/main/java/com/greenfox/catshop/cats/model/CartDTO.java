package com.greenfox.catshop.cats.model;

import java.util.List;

public class CartDTO {
    private List<CartModel> cartElements;

    public CartDTO(List<CartModel> cartElements) {
        this.cartElements = cartElements;
    }

    public CartDTO() {
    }

    public List<CartModel> getCartElements() {
        return cartElements;
    }

    public void setCartElements(List<CartModel> cartElements) {
        this.cartElements = cartElements;
    }
}
