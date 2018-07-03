package com.greenfox.catshop.cats.model;

import java.util.List;

public class CartDTO {
    private List<CartModel> elements;

    public CartDTO(List<CartModel> elements) {
        this.elements = elements;
    }

    public CartDTO() {
    }

    public List<CartModel> getElements() {
        return elements;
    }

    public void setElements(List<CartModel> elements) {
        this.elements = elements;
    }
}
