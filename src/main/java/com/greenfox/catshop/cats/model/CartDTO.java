package com.greenfox.catshop.cats.model;

import java.util.List;

public class CartDTO {
    private List<CartModel> cartElements;
    private List<Long> idList;

    public CartDTO(List<CartModel> cartElements, List<Long> idList) {
        this.cartElements = cartElements;
        this.idList = idList;
    }

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

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }
}
