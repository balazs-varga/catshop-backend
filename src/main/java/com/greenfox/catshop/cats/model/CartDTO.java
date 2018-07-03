package com.greenfox.catshop.cats.model;

import java.util.List;

public class CartDTO {
    private List<CartModel> cartElementList;

    public CartDTO(List<CartModel> cartElementList) {
        this.cartElementList = cartElementList;
    }

    public CartDTO() {
    }

    public List<CartModel> getCartElementList() {
        return cartElementList;
    }

    public void setCartElementList(List<CartModel> cartElementList) {
        this.cartElementList = cartElementList;
    }
}
