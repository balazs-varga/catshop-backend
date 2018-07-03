package com.greenfox.catshop.cats.model;

public class CartModel {
    private Long id;
    private Long piece;
    private Long cartId;

    public CartModel(Long id, Long piece, Long cartId) {
        this.id = id;
        this.piece = piece;
        this.cartId = cartId;
    }

    public CartModel(Long id, Long piece) {
        this.id = id;
        this.piece = piece;
    }

    public CartModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPiece() {
        return piece;
    }

    public void setPiece(Long piece) {
        this.piece = piece;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
