package com.greenfox.catshop.cats.model;

import java.util.List;

public class CartDTO {
    private List<CartModel> cats;

    public CartDTO(List<CartModel> cats) {
        this.cats = cats;
    }

    public CartDTO() {
    }

    public List<CartModel> getCats() {
        return cats;
    }

    public void setCats(List<CartModel> cats) {
        this.cats = cats;
    }
}
